package com.yasin.kotlindemo.core

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  Created by Yasin on 2017/5/30.
 *  Email : yasin27878@163.com
 *  Description :
 */
class ApiManager {
    companion object {
        private var okHttpClient: OkHttpClient? = null
        private var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL + "/")
                .client(getHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        fun <T> getService(clz: Class<T>): T {
            return initRetrofit()?.create(clz) as T
        }

        /**
         * okhttpclient
         */
        fun getHttpClient(): OkHttpClient? {
            okHttpClient = OkHttpClient.Builder()
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .build()
            return okHttpClient
        }

        /**
         * retrofit
         */
        fun initRetrofit(): Retrofit? {
            retrofit
            return retrofit
        }
    }


}