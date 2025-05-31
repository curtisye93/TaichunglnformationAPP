package curtis.com.taichungtravel.navigation.flower

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.RecyclerView
import curtis.com.taichungtravel.MainActivity.Companion.flowerType
import curtis.com.taichungtravel.MainActivity.Companion.spinnerFlower
import curtis.com.taichungtravel.R
import curtis.com.taichungtravel.api.ApiConnector
import curtis.com.taichungtravel.api.InterfaceApiConnector
import curtis.com.taichungtravel.data.DataFlower
import curtis.com.taichungtravel.databinding.FragmentFlowerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class FlowerFragment : Fragment() {

    private var _binding: FragmentFlowerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(FlowerViewModel::class.java)

        _binding = FragmentFlowerBinding.inflate(inflater, container, false)
        val root: View = binding.root


        lifecycle.coroutineScope.launch { // launching a coroutine (thread)
            try {
                val apiconnector = ApiConnector()
                val resultFlower = apiconnector.GetRequest(InterfaceApiConnector.urlFlower)//get data from api

                // do something with result
                DataFlower(resultFlower)
            }
            catch (exception: Exception) {
                // error here
            }
            //set adapter on recyclerview
            val recyclerView = root.findViewById<RecyclerView>(R.id.list_flower_fragment)
            with(recyclerView) {
                adapter = FlowerAdapter(DataFlower.item)
            }

            SetSpinnerFlower()
        }

/*
        val textView: TextView = binding.textFlower
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        */

        return root
    }

    //use spinner to search flower type and refresh recyclerView
    private fun CoroutineScope.SetSpinnerFlower() {
        spinnerFlower.visibility = View.VISIBLE
        spinnerFlower.setSelection(0) // set initial 0 , when change page reset setting
        spinnerFlower.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                val recyclerView = binding.root.findViewById<RecyclerView>(R.id.list_flower_fragment)
                if(flowerType[pos] == "ALL"){ //select all data
                    with(recyclerView) {
                        adapter = FlowerAdapter(DataFlower.item)
                    }
                }else{ // search flower
                    DataFlower.SetOnSearchFlower(flowerType[pos])
                    with(recyclerView) {
                        adapter = FlowerAdapter(DataFlower.itemSearch)
                    }
                }

                //Log.d("FlowerFragment", "flowerType[pos] : " + flowerType[pos])


            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        spinnerFlower.visibility = View.INVISIBLE
        _binding = null
    }
}