package com.yasin.kotlindemo.enity

/**
 *  Created by Yasin on 2017/5/30.
 *  Email : yasin27878@163.com
 *  Description :接口返回基类
 */
data class BaseEnity<T>(
        val error: Boolean,
        val results: List<T>)