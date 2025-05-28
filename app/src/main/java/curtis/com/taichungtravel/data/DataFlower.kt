package curtis.com.taichungtravel.data

import curtis.com.taichungtravel.tool.Tool.Companion.StringToJsonArray
import org.json.JSONArray
import org.json.JSONObject
import java.util.ArrayList
import java.util.HashMap

class DataFlower (result: String){
    companion object {
        lateinit var flowerData: JSONArray
        var dataSize = 0

        /**
         * A map of (placeholder) items, by ID.
         */
        val item: MutableList<DataFlowerStruct> = ArrayList()
        //val itemMap: MutableMap<String, DataTourStruct> = HashMap()
    }

    init {
        val jsonArray: JSONArray? = StringToJsonArray(result)
        if (jsonArray != null) {
            flowerData = jsonArray
            dataSize = jsonArray.length()
        }

        // Iterate through the JSONArray and print each JSONObject
        // add item to data structer
        if (jsonArray != null) {
            for (i in 0 until jsonArray.length()) {
                val jsonObject: JSONObject = jsonArray.getJSONObject(i)
                println("DataFlowerStruct: $jsonObject")
                AddItem(CreatePlaceholderItem(i, jsonObject))
            }
        }

    }

    private fun AddItem(data: DataFlowerStruct) {
        item.add(data)
    }

    private fun CreatePlaceholderItem(position: Int, jsonObject: JSONObject): DataFlowerStruct {
        return DataFlowerStruct(position.toString(),
            jsonObject.get("行政區").toString(),
            jsonObject.get("行政區代碼").toString(),
            jsonObject.get("地點").toString(),
            jsonObject.get("地址").toString(),
            jsonObject.get("花種").toString(),
            jsonObject.get("觀賞時期").toString()
        )
    }

}