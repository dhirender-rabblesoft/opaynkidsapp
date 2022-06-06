package com.app.opaynkidsapp.network

import com.app.opaynkidsapp.model.*
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.GET
interface APIInterface
{
    @GET
    fun getnumbers(@Url url: String?): Call<NumberJson>?
    @GET
    fun match(@Url url: String?): Call<MatchJson>?
    @GET
    fun objects(@Url url: String?): Call<ObjectsJson>?
    @GET
    fun fillup(@Url url: String?): Call<Fillupjson>?
    @GET
    fun dragmatch(@Url url: String?): Call<DragDropMatch>?



}