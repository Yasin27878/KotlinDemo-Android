package com.yasin.kotlindemo

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.yasin.kotlindemo.enity.Information
import com.yasin.kotlindemo.utils.SnackUtil
import kotlinx.android.synthetic.main.item_kotlin.view.*

/**
 *  Created by Yasin on 2017/5/26.
 *  Email : yasin27878@163.com
 *  Description :
 */
class KotlinAdapter(val context: Context, val list: List<Information>) : RecyclerView.Adapter<KotlinAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        val s: Information = list[p1]
        // holder.itemView.image.setImageResource()
        holder.itemView.title.text = " ${s.desc}"
        holder.itemView.tv_time.text = s.publishedAt
        holder.itemView.tv_source.text = s.source
        var url = ""
        if (s.images != null && s.images.isNotEmpty()) {
            url = "${s.images[0]}?imageView2/0/w/100"
        } else {
            url = "?imageView2/0/w/100"
        }
        Glide.with(context).load(url)
                .into(holder.itemView.image)
                .onLoadFailed(context.resources.getDrawable(R.mipmap.ic_launcher_round))

        holder.itemView.setOnClickListener { v ->
            SnackUtil.showShort(context, "第${p1}个Item")

            if (s.url != null && s.url.isNotEmpty()) {
                val intent = Intent(context, WebActivity::class.java)
                intent.putExtra("URL", s.url)
                context.startActivity(intent)
            }
        }

    }

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_kotlin, p0, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
