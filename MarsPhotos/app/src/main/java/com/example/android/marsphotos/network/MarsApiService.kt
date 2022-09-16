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

interface MarsApiService {
    @GET("photos")
    fun getPhotos(): String
}