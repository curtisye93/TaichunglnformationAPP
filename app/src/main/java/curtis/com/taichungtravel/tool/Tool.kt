package curtis.com.taichungtravel.tool

import org.json.JSONArray

//Global open tool , special function
open class Tool {
    companion object {
        fun StringToJsonArray(jsonString: String): JSONArray? {
            return try {
                JSONArray(jsonString)
            } catch (e: Exception) {
                // Handle exception, e.g., invalid JSON format
                e.printStackTrace()
                null
            }
        }
    }

}