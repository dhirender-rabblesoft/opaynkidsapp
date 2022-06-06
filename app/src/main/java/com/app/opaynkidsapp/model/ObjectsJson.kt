package com.app.opaynkidsapp.model

data class ObjectsJson(
    val `data`: ArrayList<Data>,
    val message: String,
    val status: Int
) {
    data class Data(
        val `data`: String,
        val id: String,
        val image: String,
        val color: String,
        val number: String
    )
}