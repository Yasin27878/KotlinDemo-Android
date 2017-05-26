package com.yasin.kotlindemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.yasin.kotlindemo.utils.SnackUtil
import kotlinx.android.synthetic.main.item_kotlin.view.*

/**
 *  Created by Yasin on 2017/5/26.
 *  Email : yasin27878@163.com
 *  Description :
 */
class KotlinAdapter(val context: Context, val list: List<String>) : RecyclerView.Adapter<KotlinAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        val s = list[p1]
        // holder.itemView.image.setImageResource()
        holder.itemView.text.text = " $s Kotlin ${p1 + 1}"

        holder.itemView.setOnClickListener { v ->
            SnackUtil.showShort(context, "第${p1}个Item")
        }

    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_kotlin, p0, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
