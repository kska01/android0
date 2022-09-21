package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

/**
 * Build the Moshi object with Kotlin adapter factory that Retrofit will be using.
 */
// Moshi Library is an Android JSON parser that converts a JSON string into Kotlin objects.
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * The Retrofit object with the Moshi converter.
 */
// Retrofit 은  웹 서비스의 기본 URI 와 converter factory 가 필요하다.
// converter factory 중 ScalarsConverterFactory 는 Kotlin 의 String 과 원시 타입들을 지원한다.
// ScalarsConverterFactory 는 Moshi converter 이전에 사용함.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [getPhotos] method
 */
// Create an interface that explain how Retrofit talks to our web sever
interface MarsApiService {
    // Retrofit 에게 GET 요청임을 알려주기 위해 @GET annotation 을 사용한다. 그리고 endpoint 로
    // "photos" 를 명시한다.
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
// Create a Retrofit service and expose the instance to the api service to the rest of the app.
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}