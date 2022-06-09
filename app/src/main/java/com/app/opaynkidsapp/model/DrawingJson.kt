package com.app.opaynkidsapp.model

data class DrawingJson(
    val code: Int,
    val `data`: List<Data>,
    val message: String
) {
    data class Data(
        val created_at: String,
        val id: Int,
        val image: String,
        val image_2: String,
        val name: String,
        val updated_at: String
    )
}