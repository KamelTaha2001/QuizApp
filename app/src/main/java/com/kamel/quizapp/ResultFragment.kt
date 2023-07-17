package com.kamel.quizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs

class ResultFragment : Fragment() {

    val args : ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvName : TextView? = view.findViewById(R.id.tvName)
        tvName?.text = " ${args.name}"
        val tvScore : TextView? = view.findViewById(R.id.tvScore)
        tvScore?.text = " ${args.score}/${QuizManager.questionsList.size}"
        val btnRetry : AppCompatButton? = view.findViewById(R.id.btnRetry)
        btnRetry?.setOnClickListener {
            QuizManager.resetQuiz()
            val navController = NavHostFragment.findNavController(this)
            navController.navigate(ResultFragmentDirections.actionResultFragmentToLoginFragment())
        }

    }
}