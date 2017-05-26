package com.yasin.kotlindemo.utils

import android.app.Application
import android.content.Context
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast

/**
 *  Created by Yasin on 2017/5/25.
 *  Email : yasin27878@163.com
 *  Description :Toast工具类
 */

object ToastUtil {

    var isShow = true

    private var instanceContext: Application? = null

    private var toast: Toast? = null

    fun initialize(context: Application) {
        instanceContext = context
    }

    fun show(content: String) {
        checkNotNull()
        if (toast == null) {
            toast = Toast.makeText(instanceContext, content, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(content)
        }
        toast!!.show()
    }

    fun show(content: Int) {
        checkNotNull()
        if (toast == null) {
            toast = Toast.makeText(instanceContext, content, Toast.LENGTH_SHORT)
        } else {
            toast!!.setText(content)
        }
        toast!!.show()
    }

    private fun checkNotNull() {
        checkNotNull(instanceContext)
    }

    internal fun <T> checkNotNull(`object`: T?): T {
        if (`object` == null) {
            throw NullPointerException("this object is null")
        }
        return `object`
    }


    fun showCus(context: Context?, content: String, @LayoutRes layout: Int) {
        if (null != context && isShow) {
            val contentView = LayoutInflater.from(context).inflate(layout, null)
            val toast = Toast(context)
            toast.view = contentView
            toast.show()
        }
    }

}//no instance