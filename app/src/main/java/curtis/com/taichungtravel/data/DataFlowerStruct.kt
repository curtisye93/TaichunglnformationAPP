package curtis.com.taichungtravel.data

data class DataFlowerStruct(
    val id: String,
    val adminDistrict: String, //行政區 administrative district
    val adminCode: String, //行政區代碼
    val location: String, //地點
    val address: String, //地址
    val flowerType: String, //花種
    val peakSeason: String, //觀賞時期  viewing period
)

//no need {"縣市":"臺中市",
//no need "縣市別代碼":"10019",
//ok "行政區":"后里區",
//ok "行政區代碼":"66000150",
//ok "地點":"中社花市",
//ok "地址":"臺中市后里區三豐路五段333號",
//ok "花種":"鬱金香",
//ok "觀賞時期":"1月-3月"}