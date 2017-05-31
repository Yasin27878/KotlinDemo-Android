package com.yasin.kotlindemo

import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.webkit.*

import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.layout_toolbar.*

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
        toolbar.title = "KotlinDemo"
        web.setWebViewClient(MyWebViewClient())
        web.setWebChromeClient(object : WebChromeClient() {
            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                toolbar.title = title
            }

        })

        fab.setOnClickListener {
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }


/*    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        *//*  val item: MenuItem = menu.findItem(R.id.action_settings)
          item.title = "使用浏览器打开"
          item.icon = resources.getDrawable(android.R.drawable.ic_menu_share)*//*
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_settings) {
            val uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }*/

    class MyWebViewClient : WebViewClient() {
        override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
            super.onReceivedSslError(view, handler, error)
            handler?.proceed()
        }
    }
}

