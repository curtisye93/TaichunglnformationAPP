package curtis.com.taichungtravel.data

import curtis.com.taichungtravel.tool.Tool.Companion.StringToJsonArray
import org.json.JSONArray
import org.json.JSONObject
import java.util.ArrayList
import java.util.HashMap

class DataTourist (result: String){
    companion object {
        lateinit var tourData: JSONArray
        var dataSize = 0
        var dataSelect = 0

        /**
         * A map of (placeholder) items, by ID.
         */
        val item: MutableList<DataTourStruct> = ArrayList()
        //val itemMap: MutableMap<String, DataTourStruct> = HashMap()
    }
    /*
    data class DataTourStruct(
        val id: String, val nameEN: String, val nameTW: String, val contentEN: String, val contentTW: String, val contact: String
    )
*/

    init {
        val jsonArray: JSONArray? = StringToJsonArray(result)
        if (jsonArray != null) {
            tourData = jsonArray
            dataSize = jsonArray.length()
        }

        // Iterate through the JSONArray and print each JSONObject
        // add item to data structer
        if (jsonArray != null) {
            for (i in 0 until jsonArray.length()) {
                val jsonObject: JSONObject = jsonArray.getJSONObject(i)
                println("DataTourStruct: $jsonObject")
                AddItem(CreatePlaceholderItem(i, jsonObject))
            }
        }

    }

    private fun AddItem(data: DataTourStruct) {
        item.add(data)
        //itemMap.put(data.id, data)
    }

    private fun CreatePlaceholderItem(position: Int, jsonObject: JSONObject): DataTourStruct {
        return DataTourStruct(position.toString(),
            jsonObject.get("景點英文名稱").toString(),
            jsonObject.get("景點中文名稱").toString(),
            jsonObject.get("景點特色簡述(英文)").toString(),
            jsonObject.get("景點特色簡述(中文)").toString(),
            jsonObject.get("景點英文地址").toString(),
            jsonObject.get("景點中文地址").toString(),
            jsonObject.get("景點服務電話").toString(),
            jsonObject.get("經度").toString(),
            jsonObject.get("緯度").toString(),
            jsonObject.get("設施圖示編號").toString(),
            jsonObject.get("開放時間").toString(),
            jsonObject.get("照片連結網址1").toString(),
            jsonObject.get("照片中文說明1").toString(),
            jsonObject.get("網址").toString(),
            jsonObject.get("(選填)地圖服務連結").toString()
        )
    }

}