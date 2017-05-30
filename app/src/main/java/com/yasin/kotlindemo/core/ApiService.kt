package com.yasin.kotlindemo.core

import com.yasin.kotlindemo.enity.BaseEnity
import com.yasin.kotlindemo.enity.Information
import io.reactivex.Observable
import retrofit2.http.*


/**
 *  Created by Yasin on 2017/5/30.
 *  Email : yasin27878@163.com
 *  Description :接口服务
 */
interface ApiService {


    @GET("data/Android/{date}")
    fun getDayData(@Path("date") date: String): Observable<BaseEnity<Information>>


    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Observable<BaseEnity<Information>>

    @GET("group/{id}/users")
    fun groupList(@Path("id") groupId: Int): Observable<List<Information>>

    @FormUrlEncoded
    @POST("user/edit")
    fun updateUser(@Field("first_name") first: String, @Field("last_name") last: String): Observable<Information>

}