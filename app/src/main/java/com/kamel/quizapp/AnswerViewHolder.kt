package com.kamel.quizapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnswerViewHolder(itemView : View, data : Answer) : RecyclerView.ViewHolder(itemView) {
    val answerText = itemView.findViewById<TextView>(R.id.answerText)
}