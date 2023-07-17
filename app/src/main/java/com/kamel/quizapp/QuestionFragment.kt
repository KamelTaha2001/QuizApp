package com.kamel.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuestionFragment : Fragment() {

    val args : QuestionFragmentArgs by navArgs()
    var tvQuestion : TextView? = null
    var ivFlag : ImageView? = null
    var rvAnswers : RecyclerView? = null
    var btnNext : AppCompatButton? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI(view)
        showNextQuestion()
    }

    private fun initializeUI(view : View) {
        tvQuestion = view.findViewById(R.id.tvQuestion)
        ivFlag = view.findViewById(R.id.ivFlag)
        rvAnswers = view.findViewById(R.id.rvAnswers)
        rvAnswers?.layoutManager = LinearLayoutManager(context)
        btnNext = view.findViewById(R.id.btnNext)
        btnNext?.setOnClickListener {
            QuizManager.moveToNextQuestion()
            if (QuizManager.isLastQuestion) {
                btnNext?.text = getString(R.string.finish)
                btnNext?.setOnClickListener {
                    TODO("Move to result screen")
                }
            }
            showNextQuestion()
        }
    }

    private fun showNextQuestion() {
        tvQuestion?.text = getString(QuizManager.questionsList[QuizManager.currentQuestion].questionText)
        ivFlag?.setImageResource(QuizManager.questionsList[QuizManager.currentQuestion].flag)
        rvAnswers?.adapter = AnswersAdapter(QuizManager.questionsList[QuizManager.currentQuestion].answers)
    }
}