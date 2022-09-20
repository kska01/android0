package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

// Retrofit 은  웹 서비스의 기본 URI 와 converter factory 가 필요하다.
// converter factory 중 ScalarsConverterFactory 는 Kotlin 의 String 과 원시 타입들을 지원한다.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// Create an interface that explain how Retrofit talks to our web sever
interface MarsApiService {
    // Retrofit 에게 GET 요청임을 알려주기 위해 @GET annotation 을 사용한다. 그리고 endpoint 로
    // "photos" 를 명시한다.
    @GET("photos")
    suspend fun getPhotos(): String
}

// Create a Retrofit service and expose the instance to the api service to the rest of the app.
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}