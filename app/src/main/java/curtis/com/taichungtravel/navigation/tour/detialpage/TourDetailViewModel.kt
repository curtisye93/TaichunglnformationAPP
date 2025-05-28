package curtis.com.taichungtravel.navigation.tour.detialpage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.squareup.picasso.Picasso
import curtis.com.taichungtravel.data.DataTourist
import curtis.com.taichungtravel.data.DataTourist.Companion.dataSelect
import curtis.com.taichungtravel.navigation.tour.Setting

class TourDetailViewModel : ViewModel() {
    private var position = 0
    private var item = DataTourist.item[dataSelect]

    //change fragment component by data
    private val textContent = MutableLiveData<String>().apply {
        var str = ""
        if(Setting.language == Setting.LANGUAGE_TW){
            str = item.nameTW + " : " + item.openingHour + "\n" +
                    "地址   : " + item.addressTW + "\n" +
                    "聯絡電話: " + item.contact + "\n" +
                    "設施圖示編號 : " + item.facilityNumber + "\n\n" +
                    item.contentTW + "\n"

        }else{
            str = item.nameEN + " : " + item.openingHour + "\n" +
                    "address   : " + item.addressEN + "\n" +
                    "contact   : " + item.contact + "\n" +
                    "facility Number : " + item.facilityNumber + "\n\n" +
                    item.contentEN + "\n"
        }
        value = str
    }
    val text: LiveData<String> = textContent

    private val textWeb = MutableLiveData<String>().apply {
        value = item.website
    }
    val textWebUrl : LiveData<String> = textWeb



    fun SetPosition(pos : Int){
        position = pos
    }

}