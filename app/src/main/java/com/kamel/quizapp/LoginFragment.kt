package com.kamel.quizapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = NavHostFragment.findNavController(this)
        val btnLogin = view.findViewById<AppCompatButton>(R.id.btnLogin)
        btnLogin?.setOnClickListener {
            val etName : AppCompatEditText = view.findViewById(R.id.etName)
            val action = LoginFragmentDirections.actionLoginFragmentToQuestionFragment(etName.text.toString())
            navController.navigate(action)
        }
    }
}