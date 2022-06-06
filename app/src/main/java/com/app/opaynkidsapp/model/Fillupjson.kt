package com.app.opaynkidsapp.model

data class Fillupjson(
    val data: ArrayList<Data>,
    val message: String,
    val vode: Int
)
{
    data class Data(val id:Int,var image:String,val  answer:String,val  incorrect_answer:String)
}