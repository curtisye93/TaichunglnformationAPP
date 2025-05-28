package curtis.com.taichungtravel.navigation.tour

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import curtis.com.taichungtravel.MainActivity
import curtis.com.taichungtravel.MainActivity.Companion.buttonLanguage
import curtis.com.taichungtravel.R
import curtis.com.taichungtravel.data.DataTourist
import curtis.com.taichungtravel.databinding.FragmentTourBinding
import curtis.com.taichungtravel.navigation.tour.Setting.Companion.POSITION_KEY
import curtis.com.taichungtravel.navigation.tour.TourFragment.StaticFunction.SetMyContext
import curtis.com.taichungtravel.navigation.tour.detialpage.TourDetailActivity

class TourFragment : Fragment() {

    private var _binding: FragmentTourBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val view = inflater.inflate(R.layout.fragment_tour, container, false)
        //val view = inflater.inflate(R.id.ListTourFragment, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.list_tour_fragment)
        with(recyclerView) {
            adapter = TourAdapter(DataTourist.item)
        }

        SetButtonLanguage(recyclerView)

        SetMyContext(view.context)


        /*
        val view = inflater.inflate(R.id.ListTourFragment, container, false)
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    DataTourist.dataSize <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, DataTourist.dataSize)
                }
                adapter = TourAdapter(DataTourist.item)
            }

        }

         */
        return view
    }

    private fun SetButtonLanguage(view: RecyclerView) {
        buttonLanguage.visibility = View.VISIBLE
        buttonLanguage.setOnClickListener {
            if (Setting.language == Setting.LANGUAGE_TW){
                Setting.language = Setting.LANGUAGE_EN
                buttonLanguage.setText(Setting.LANGUAGE_EN)
            }else{
                Setting.language = Setting.LANGUAGE_TW
                buttonLanguage.setText(Setting.LANGUAGE_TW)
            }
            with(view) {
                adapter = TourAdapter(DataTourist.item)
            }

        }
    }

//for on click adapter list , start detail activity
    object StaticFunction{
        private lateinit var appContext: Context

        fun SetMyContext(context: Context) {
            appContext = context
        }

        fun StartActivity(context: Context, targetActivity: Class<*>,position: Int) {
            val intent = Intent(context, targetActivity)
            intent.putExtra(POSITION_KEY,position)
            context.startActivity(intent)
        }
        fun OnAdapterClick(position: Int) {
            StartActivity(appContext, TourDetailActivity::class.java,position)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        MainActivity.buttonLanguage.visibility = View.INVISIBLE
        _binding = null
    }
}