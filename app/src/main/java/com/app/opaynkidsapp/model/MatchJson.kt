package com.app.opaynkidsapp.model

data class MatchJson(
    val code: Int,
    val `data`: Data,
    val message: String
) {
    data class Data(
        val answer: List<Answer>,
        val question: List<Question>
    ) {
        data class Answer(
            val answer: String,
            val id: Int,
            val match_question_id: Int,
            val image: String
        )

        data class Question(
            val answer_id: Int,
            val id: Int,
            val question: String
        )
    }
}