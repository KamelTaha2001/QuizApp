package com.kamel.quizapp

import android.graphics.Color
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat

object QuizManager {

    lateinit var questionsList : ArrayList<Question>
    var currentQuestion : Int = 0
    var score : Int = 0
    var isLastQuestion = false
    var isAnswerCorrect = false

    init {
        questionsList = ArrayList(10)
        questionsList.add(QuestionGenerator.generateQuestion(R.drawable.ic_flag_of_argentina, Answer("Argentina")))
        questionsList.add(QuestionGenerator.generateQuestion(R.drawable.ic_flag_of_belgium, Answer("Belgium")))
        questionsList.add(QuestionGenerator.generateQuestion(R.drawable.ic_flag_of_brazil, Answer("Brazil")))
        questionsList.add(QuestionGenerator.generateQuestion(R.drawable.ic_flag_of_germany, Answer("Germany")))
        questionsList.add(QuestionGenerator.generateQuestion(R.drawable.ic_flag_of_denmark, Answer("Denmark")))
        questionsList.add(QuestionGenerator.generateQuestion(R.drawable.ic_flag_of_australia, Answer("Australia")))
        questionsList.add(QuestionGenerator.generateQuestion(R.drawable.ic_flag_of_india, Answer("India")))
        questionsList.add(QuestionGenerator.generateQuestion(R.drawable.ic_flag_of_kuwait, Answer("Kuwait")))
        questionsList.add(QuestionGenerator.generateQuestion(R.drawable.ic_flag_of_new_zealand, Answer("New Zealand")))
    }

    fun chooseAnswer(newTv : TextView, oldTv : TextView?) {
        oldTv?.setBackgroundResource(R.drawable.default_answer)
        oldTv?.setTextColor(Color.parseColor("#${Integer.toHexString(ContextCompat.getColor(newTv.context, R.color.light_gray))}"))
        newTv.setBackgroundResource(R.drawable.chosen_answer)
        newTv.setTextColor(Color.parseColor("#${Integer.toHexString(ContextCompat.getColor(newTv.context, R.color.white))}"))

        isAnswerCorrect = newTv.text.toString() == questionsList[currentQuestion].correctAnswer.answerText
    }

    fun moveToNextQuestion() {
        if (isAnswerCorrect) score++
        isAnswerCorrect = false

        currentQuestion++
        if (currentQuestion == questionsList.size - 1) isLastQuestion = true
    }

    fun resetQuiz() {
        score = 0
        currentQuestion = 0
        isAnswerCorrect = false
        isLastQuestion = false
    }
}