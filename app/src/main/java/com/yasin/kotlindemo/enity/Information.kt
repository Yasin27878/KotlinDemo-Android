package com.yasin.kotlindemo.enity

/**
 *  Created by Yasin on 2017/5/30.
 *  Email : yasin27878@163.com
 *  Description : 文章信息基类
 */
data class Information(val _id: String,
                       val createdAt: String,
                       val desc: String,
                       val images: List<String>,
                       val publishedAt: String,
                       val source: String,
                       val type: String,
                       val url: String,
                       val used: String,
                       val who: String
)