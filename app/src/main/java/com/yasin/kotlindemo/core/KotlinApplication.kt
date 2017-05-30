package com.yasin.kotlindemo.core

import android.app.Application
import com.yasin.kotlindemo.utils.ToastUtil
import retrofit2.Retrofit


/**
 *  Created by Yasin on 2017/5/26.
 *  Email : yasin27878@163.com
 *  Description :
 */
class KotlinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ToastUtil.initialize(this)
        instance = this
    }

    companion object {
        private var instance: KotlinApplication? = null
        var service: ApiService = ApiManager.getService(ApiService::class.java)
        fun instance() = instance!!
    }
}