package curtis.com.taichungtravel.navigation.flower

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.RecyclerView
import curtis.com.taichungtravel.R
import curtis.com.taichungtravel.api.ApiConnector
import curtis.com.taichungtravel.api.InterfaceApiConnector
import curtis.com.taichungtravel.data.DataFlower
import curtis.com.taichungtravel.data.DataTourist
import curtis.com.taichungtravel.databinding.FragmentFlowerBinding
import curtis.com.taichungtravel.navigation.tour.TourAdapter
import kotlinx.coroutines.delay
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
        }
/*
        val textView: TextView = binding.textFlower
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        */

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}