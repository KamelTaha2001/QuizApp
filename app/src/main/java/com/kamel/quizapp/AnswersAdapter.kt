package com.kamel.quizapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnswersAdapter(private val dataList : List<Answer>) : RecyclerView.Adapter<AnswerViewHolder>() {

    val data  = ArrayList<Answer>(dataList)
    var currentSelectedAnswer : TextView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.answer_view, parent, false)
        return AnswerViewHolder(itemView, dataList[viewType])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        val answer = data.random()
        data.remove(answer)
        holder.answerText.text = answer.answerText
        makeAnswerClickable(holder.answerText)
    }

    private fun makeAnswerClickable(tv : TextView) {
        tv.setOnClickListener {
            if (currentSelectedAnswer == null)
                currentSelectedAnswer = tv
            QuizManager.chooseAnswer(tv, currentSelectedAnswer!!)
            currentSelectedAnswer = tv
        }
    }
}