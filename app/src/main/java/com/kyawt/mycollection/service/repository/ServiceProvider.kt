package com.kyawt.mycollection.service.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ServiceProvider {

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"

        fun getService(): PhotoService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(PhotoService::class.java)
        }

    }

}