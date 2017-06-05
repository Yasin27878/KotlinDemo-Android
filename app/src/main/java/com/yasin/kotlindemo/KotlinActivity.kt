package com.yasin.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.yasin.kotlindemo.core.KotlinApplication
import com.yasin.kotlindemo.enity.Information
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_kotlin.*
import kotlinx.android.synthetic.main.layout_toolbar.*


/**
 *  Created by Yasin on 2017/5/18.
 *  Email : yasin27878@163.com
 *  Description :
 */
class KotlinActivity : AppCompatActivity() {
    private val TAG: String = KotlinActivity::class.java.simpleName
    var mAdapter: KotlinAdapter? = null
    var mList = arrayListOf<Information>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        tv_name.text = "Hello Kotlin"
        toolbar.title = "文章列表"
        init()

    }

    private fun init() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        mAdapter = KotlinAdapter(this, mList)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        recyclerview.adapter = mAdapter
        getData("")
        mAdapter!!.setOnItemClickListener {
            pos ->
            val info: Information = mList.get(pos)
        }

    }

    fun getData(date: String) {
        KotlinApplication.service.getDayData("10/1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    if (!it.error) {
                        mList.clear()
                        mList.addAll(it.results)
                        mAdapter!!.notifyDataSetChanged()
                    }

                })
    }
}