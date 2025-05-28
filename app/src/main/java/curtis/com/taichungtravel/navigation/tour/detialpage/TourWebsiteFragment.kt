package curtis.com.taichungtravel.navigation.tour.detialpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.navigation.fragment.findNavController
import curtis.com.taichungtravel.R
import curtis.com.taichungtravel.data.DataTourist
import curtis.com.taichungtravel.data.DataTourist.Companion.dataSelect
import curtis.com.taichungtravel.databinding.FragmentTourWebsiteBinding

/**
 * A  [Fragment] subclass as the second destination in the navigation.
 */
class TourWebsiteFragment : Fragment() {

    private var _binding: FragmentTourWebsiteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var myWebView: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTourWebsiteBinding.inflate(inflater, container, false)
        SetInitial()

        return binding.root

    }

    private fun SetInitial() {
        myWebView = binding.webviewTour
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //enable javascript use
        myWebView.settings.javaScriptEnabled = true
        //set webview load url
        myWebView.loadUrl(DataTourist.item[dataSelect].website)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}