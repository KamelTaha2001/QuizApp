package com.kamel.quizapp

import android.util.Log

object QuestionGenerator {

    // TODO("What is better, to be of type Answer or String ?")
    lateinit var allAvailableAnswers : ArrayList<String>

    init {
        allAvailableAnswers = ArrayList(150)
    }

    fun generateQuestion(flag : Int, correctAnswer: Answer, numAnswers: Int = 4) : Question {

        val answers : ArrayList<Answer> = ArrayList(numAnswers)
        answers.add(correctAnswer)

        var x = 1
        while(x < numAnswers) {
            var answerString : String? = null
            do  {
                answerString = allAvailableAnswers.random()
            } while (answerString == correctAnswer.answerText)

            val newAnswer = Answer(answerString!!)
            answers.add(newAnswer)
            x++
        }

        return Question(
            R.string.default_question_text,
            flag,
            answers,
            correctAnswer
        )
    }
}