package com.app.opaynkidsapp.model

data class NumberJson(
    val `data`: List<Data>,
    val message: String,
    val status: Int
) {
    data class Data(
        val `data`: String,
        val id: String,
        val image: String,
        val number: String
    )
}