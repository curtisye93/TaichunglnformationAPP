package curtis.com.taichungtravel.navigation.flower

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FlowerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "flower page"
    }
    val text: LiveData<String> = _text
}