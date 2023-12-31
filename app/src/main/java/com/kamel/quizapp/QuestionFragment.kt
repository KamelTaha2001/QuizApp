package com.kamel.quizapp

import android.database.Observable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuestionFragment : Fragment() {

    val args : QuestionFragmentArgs by navArgs()
    var tvQuestion : TextView? = null
    var ivFlag : ImageView? = null
    private var rvAnswers : RecyclerView? = null
    var btnNext : AppCompatButton? = null
    private var answerAdapter : AnswersAdapter? = null
    private val finishClickListener = View.OnClickListener {
        QuizManager.moveToNextQuestion()
        val navController = NavHostFragment.findNavController(this)
        val action = QuestionFragmentDirections.actionQuestionFragmentToResultFragment(args.name, QuizManager.score)
        navController.navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
            showNextQuestion()
            if (QuizManager.isLastQuestion) {
                btnNext?.text = getString(R.string.finish)
                btnNext?.setOnClickListener(finishClickListener)
            }
        }
    }

    private fun showNextQuestion() {
        tvQuestion?.text = getString(QuizManager.questionsList[QuizManager.currentQuestion].questionText)
        ivFlag?.setImageResource(QuizManager.questionsList[QuizManager.currentQuestion].flag)
        updateAdapterData()
    }

    private fun updateAdapterData() {
        if (answerAdapter == null) {
            answerAdapter = AnswersAdapter(QuizManager.questionsList[QuizManager.currentQuestion].answers)
            rvAnswers?.adapter = answerAdapter
        } else {
            answerAdapter?.updateDataSet(QuizManager.questionsList[QuizManager.currentQuestion].answers)
        }
    }
}