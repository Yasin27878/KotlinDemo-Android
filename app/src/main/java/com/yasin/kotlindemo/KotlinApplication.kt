package com.yasin.kotlindemo

import android.app.Application
import com.yasin.kotlindemo.utils.ToastUtil

/**
 *  Created by Yasin on 2017/5/26.
 *  Email : yasin27878@163.com
 *  Description :
 */
class KotlinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ToastUtil.initialize(this)
    }
}