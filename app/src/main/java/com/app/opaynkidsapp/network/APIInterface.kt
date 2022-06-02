package com.app.opaynkidsapp.network

import com.app.opaynkidsapp.model.NumberJson
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET
interface APIInterface {


    @GET
    fun getnumbers(@Url url: String?): Call<NumberJson>?



}