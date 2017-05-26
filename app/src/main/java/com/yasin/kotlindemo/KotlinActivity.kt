package com.yasin.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_kotlin.*


/**
 *  Created by Yasin on 2017/5/18.
 *  Email : yasin27878@163.com
 *  Description :
 */
class KotlinActivity : AppCompatActivity() {
    private val TAG: String = KotlinActivity::class.java.simpleName
    var mAdapter: KotlinAdapter? = null
    var mList: List<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        tv_name.text = "Hello Kotlin"
        init()

    }

    private fun init() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        mList = getData(8)
        mAdapter = KotlinAdapter(this, mList)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = mAdapter

    }

    fun getData(name: Int): List<String> {
        var list = arrayListOf<String>()
        var i = 0
        while (i < name) {
            list.add("Hello ")
            i++
        }
        return list
    }
}