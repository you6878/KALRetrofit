package com.company.howl.howlretrofit

import retrofit2.Call
import retrofit2.http.*

data class ResponseDTO(var result: String? = null)

interface HowlService {

    @GET("/howl")
    fun getRequest(@Query("name") name: String): Call<ResponseDTO>

    @GET("/howl/{id}")
    fun getParamRequest(@Path("id") id: String): Call<ResponseDTO>
    //FormData
    //UrlEncoded
    @FormUrlEncoded
    @POST("/howl")
    fun postRequest(@Field("id") id: String,
                    @Field("password") password: String): Call<ResponseDTO>
    @FormUrlEncoded
    @PUT("/howl/{id}")
    fun putRequest(@Path("id") id: String,
                   @Field("content") content: String): Call<ResponseDTO>

    @DELETE("/howl/{id}")
    fun deleteRequest(@Path("id") id: String): Call<ResponseDTO>

}