package curtis.com.taichungtravel.navigation.tour.detialpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import curtis.com.taichungtravel.R
import curtis.com.taichungtravel.databinding.FragmentTourDetailBinding
import curtis.com.taichungtravel.data.DataTourist

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TourDetailFragment : Fragment() {

    private var _binding: FragmentTourDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var textViewContent: TextView
    private lateinit var buttonWebUrl: TextView
    private lateinit var imageViewPicture: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTourDetailBinding.inflate(inflater, container, false)
        SetInitial()

        return binding.root
    }

    private fun SetInitial() {
        textViewContent = binding.textviewContent
        buttonWebUrl = binding.buttonWebUrl
        imageViewPicture = binding.imageViewTourPicture
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get().load(DataTourist.item[DataTourist.dataSelect].photoLink).into(imageViewPicture)
        val tourViewModel = ViewModelProvider(this).get(TourDetailViewModel::class.java)
        //tourViewModel.SetPosition(2)
        tourViewModel.text.observe(viewLifecycleOwner) {
            textViewContent.text = it
        }
        tourViewModel.textWebUrl.observe(viewLifecycleOwner) {
            buttonWebUrl.text = it
        }

        binding.buttonWebUrl.setOnClickListener {
            findNavController().navigate(R.id.action_TourFragment_to_WebsiteFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}