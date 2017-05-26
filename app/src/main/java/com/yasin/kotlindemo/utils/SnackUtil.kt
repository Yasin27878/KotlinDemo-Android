package com.yasin.kotlindemo.utils

import android.content.Context
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup

/**
 *  Created by Yasin on 2017/5/26.
 *  Email : yasin27878@163.com
 *  Description :SnackBar工具类
 */
object SnackUtil {
    fun showShort(context: Context, msg: String) {

        Snackbar.make(findFirstView(context as AppCompatActivity), msg, Snackbar.LENGTH_SHORT).show()
    }

    fun showShort(context: Context, @StringRes msg: Int) {
        Snackbar.make(findFirstView(context as AppCompatActivity), msg, Snackbar.LENGTH_SHORT).show()
    }


    fun showLong(context: Context, msg: String) {
        Snackbar.make(findFirstView(context as AppCompatActivity), msg, Snackbar.LENGTH_LONG).show()
    }

    fun showLong(context: Context, @StringRes msg: Int) {
        Snackbar.make(findFirstView(context as AppCompatActivity), msg, Snackbar.LENGTH_LONG).show()
    }

    /**
     * 可交互的Snackbar

     * @param context
     * *
     * @param msg
     * *
     * @param action
     * *
     * @param callBack
     */
    fun showAction(context: Context, msg: String, action: String, callBack: ActionCallBack) {
        val snackbar = Snackbar.make(findFirstView(context as AppCompatActivity), msg, Snackbar.LENGTH_LONG)
        snackbar.setAction(action) {
            snackbar.dismiss()
            callBack.click()
        }
        snackbar.show()
    }


    private fun findFirstView(activity: AppCompatActivity): View {
        return (activity.window.decorView.findViewById(android.R.id.content) as ViewGroup).getChildAt(0)
    }

    public interface ActionCallBack {
        fun click()
    }

}