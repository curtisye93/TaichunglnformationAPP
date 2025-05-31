package curtis.com.taichungtravel.api

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/*
* Copyright 2025 Curtis.
* use okhttp connect api
*/

class ApiConnector : InterfaceApiConnector {
    val okHttpClient = OkHttpClient().newBuilder()// Sets the maximum time to establish a connection to 10 seconds
        .connectTimeout(10, TimeUnit.SECONDS)
        // Sets the maximum time to wait for data to be received to 10 seconds
        .readTimeout(10, TimeUnit.SECONDS)
        // Sets the maximum time to wait for data to be sent to 10 seconds
        .writeTimeout(10, TimeUnit.SECONDS).build()

    // suspendCoroutine - suspends a coroutine until request is executed
    override suspend fun GetRequest(urlString : String): String = suspendCoroutine { continuation ->
        val request = Request.Builder()
            .url(urlString)
            .build()
        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                continuation.resumeWithException(e) // resume calling coroutine
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    continuation.resume(response.body!!.string()) // resume calling coroutine
                }
            }
        })
    }
}