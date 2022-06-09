package com.app.opaynkidsapp.model

data class McqJson(
    val code: Int,
    val `data`: List<Data>,
    val message: String
) {
    data class Data(
        val answer: String,
        val created_at: String,
        val drag_drop_category_id: Int,
        val id: Int,
        val image: String,
        val name: String,
        val options: List<Option>,
        val status: String,
        val updated_at: String
    ) {
        data class Option(
            val created_at: String,
            val drag_drop_question_id: Int,
            val id: Int,
            val name: String,
            val updated_at: String
        )
    }
}