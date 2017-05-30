package com.yasin.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.*
import kotlinx.android.synthetic.main.activity_web.*

/**
 *  Created by Yasin on 2017/5/30.
 *  Email : yasin27878@163.com
 *  Description :
 */
class WebActivity : AppCompatActivity() {
    var url = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        url = intent.getStringExtra("URL")
        val webSetting: WebSettings = web.settings
        webSetting.javaScriptEnabled = true
        webSetting.allowFileAccess = true
        webSetting.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        webSetting.setSupportZoom(true)
        webSetting.loadWithOverviewMode = true
        webSetting.cacheMode = WebSettings.LOAD_NO_CACHE
        webSetting.useWideViewPort = true
        webSetting.setSupportMultipleWindows(true)
        webSetting.domStorageEnabled = true
        webSetting.javaScriptCanOpenWindowsAutomatically = true
        webSetting.setAppCacheEnabled(false)
        webSetting.allowFileAccess = true // 允许访问文件
        webSetting.setGeolocationEnabled(true)
        web.loadUrl(url)

    }

}