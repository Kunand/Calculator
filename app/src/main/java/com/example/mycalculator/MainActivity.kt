package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var tvInput: TextView? = null
    var lastNumeric: Boolean = false
    var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tvInput)
    }
    fun onDigit(view:View){
        tvInput?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }

    fun onClear(view: View){
        tvInput?.text = ""
        lastNumeric = false
        lastDot = false
    }

    fun onDecimalPoint(view: View){
        if(lastNumeric && !lastDot){
            tvInput?.append(".")
            lastDot = true
            lastNumeric = false
        }
    }

    fun onOperator(view: View){
        tvInput?.text?.let{
            if(lastNumeric && !isOperator(it.toString())){
                tvInput?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }

    }

    private fun isOperator(value: String) :Boolean{
        return if(value.startsWith("-")){
            false
        }   else{
            value.contains("+") ||
            value.contains("*") ||
            value.contains("-") ||
            value.contains("/")
        }
    }

}