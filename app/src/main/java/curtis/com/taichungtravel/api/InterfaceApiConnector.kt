package curtis.com.taichungtravel.api

interface InterfaceApiConnector {
    companion object {
        //taichung tourist api
        val urlTourist: String
            get() = "https://datacenter.taichung.gov.tw/swagger/OpenData/38476e5e-9288-4b83-bb33-384b1b36c570"

        //taichung flower api
        val urlFlower: String
            get() = "https://datacenter.taichung.gov.tw/swagger/OpenData/f116d1db-56f7-4984-bad8-c82e383765c0"
    }

    suspend fun GetRequest(urlString : String): String
}