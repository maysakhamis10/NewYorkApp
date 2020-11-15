package com.example.newyorktimes.data.apis

import com.example.newyorktimes.utilis.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(SynchronousCallAdapterFactory.create())
            .build()
    }

}

