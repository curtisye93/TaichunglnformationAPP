package curtis.com.taichungtravel.data

data class DataTouristGsonTest(
    val spot: List<TourSpot>,
    val type: String
)

data class TourSpot(
    val info: String,
    //val info: TourInformation,
    val type: String
)
/*
data class TourInformation(
    val 景點中文名稱: String,
    val 景點英文名稱: String,
    val 景點中文地址: String
)
*/