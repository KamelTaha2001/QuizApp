package com.kamel.quizapp

data class Question(
    val questionText : Int,
    val flag : Int,
    val answers : ArrayList<Answer>,
    val correctAnswer : Answer
)