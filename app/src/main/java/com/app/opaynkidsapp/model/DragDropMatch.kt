package com.app.opaynkidsapp.model

data class DragDropMatch(
    val `data`: Data,
    val message: String,
    val status: Int
) {
    data class Data(
        val correct_ans: String,
        val image: String,
        val selectanswer: List<Selectanswer>
    ) {
        data class Selectanswer(
            val ans: String,
            val id: String
        )
    }
}