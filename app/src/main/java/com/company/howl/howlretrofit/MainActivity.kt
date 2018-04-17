package com.company.howl.howlretrofit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //192.168.0.101:3000

        var retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.101:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        var server = retrofit.create(HowlService::class.java)

        button_get.setOnClickListener {

            server.getRequest("하울").enqueue(object:Callback<ResponseDTO>{
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    println(response?.body().toString())
                }

            })
        }

        button_get_param.setOnClickListener {

            server.getParamRequest("board01").enqueue(object:Callback<ResponseDTO>{
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    println(response?.body().toString())
                }

            })
        }

        button_post.setOnClickListener {

            server.postRequest("you6878@icloud.com","1234").enqueue(object : Callback<ResponseDTO>{
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    println(response?.body().toString())
                }

            })
        }

        button_update.setOnClickListener {

            server.putRequest("board01","수정할 내용").enqueue(object:Callback<ResponseDTO>{
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    println(response?.body().toString())
                }

            })
        }
        button_delete.setOnClickListener {
            server.deleteRequest("board01").enqueue(object:Callback<ResponseDTO>{
                override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ResponseDTO>?, response: Response<ResponseDTO>?) {
                    println(response?.body().toString())
                }

            })
        }

    }
}
