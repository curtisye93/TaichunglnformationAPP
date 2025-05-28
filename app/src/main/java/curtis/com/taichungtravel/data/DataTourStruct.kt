package curtis.com.taichungtravel.data

data class DataTourStruct(
    val id: String,
    val nameEN: String, //景點英文名稱
    val nameTW: String, //景點中文名稱
    val contentEN: String, //景點特色簡述(英文)
    val contentTW: String, //景點特色簡述(中文)
    val addressEN: String, //景點英文地址
    val addressTW: String, //景點中文地址


    val contact: String, //景點服務電話
    val longitude: String, //經度
    val latitude: String, //緯度
    val facilityNumber: String, //設施圖示編號
    val openingHour: String, //開放時間
    val photoLink: String, //照片連結網址1
    val photoCaption: String, //照片中文說明1
    val website: String, //網址
    val mapLink: String //(選填)地圖服務連結
)

//ok l "景點中文名稱":"大甲及大安區自行車道","景點英文名稱":"Dajia & Daan Bikeway",
//ok l "景點特色簡述(中文)":"串聯大甲及大安區的自行車道，位於西部沿海，沿途欣賞海岸風光及濕地生態，寓教於樂，適合親子同遊。","景點特色簡述(英文)":"The bikeway is located at the west coast whicht connects Dajia and Daan District.  The recreational  coastal view and the ecology of wetland make it a perfect eductioual attraction for families.",
// "海域活動圖式編號":"-",
//ok "設施圖示編號":"2,3,4,8,11,14,15",
//ok "經度":"120.58535","緯度":"24.38366",
//ok "景點服務電話":"(04)26804957",
//ok "景點中文地址":"臺中市大安區北汕路86巷1號","景點英文地址":"No. 1, Ln. 86, Beishan Rd., Da'an Dist., Taichung City",
//ok "開放時間":"00:00-24:00",
// "開放時間備註":"","開放時間英文備註":"",
//ok "照片連結網址1":"https:\/\/travel.taichung.gov.tw\/Utility\/DisplayImage?id=35176",
//ok "照片中文說明1":"大甲及大安區自行車道",
//ok "網址":"https:\/\/travel.taichung.gov.tw\/zh-tw\/Experience\/CyclingTrip\/9\/%E5%A4%A7%E7%94%B2%E5%8F%8A%E5%A4%A7%E5%AE%89%E5%8D%80%E8%87%AA%E8%A1%8C%E8%BB%8A%E9%81%93",
//ok "(選填)地圖服務連結":"https:\/\/goo.gl\/maps\/t3hkDwx6KFq7WQzM6"