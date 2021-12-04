package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    private var textView:TextView? = null

    var lastNumeric: Boolean = false
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.tvInput)
    }

    fun onDigit(view: View){
        textView?.append((view as Button).text)
        lastNumeric = true
        lastDot = false
    }

    fun clear(view: View){
        textView?.text=""
    }

    fun onDecimalPoint(view:View){
        if(lastNumeric && !lastDot){
            textView?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view:View){
        textView?.text?.let {
            if(lastNumeric && !isOperatorAdded(it.toString())){
                textView?.append((view as Button).text)
            }
        }
    }

    private fun isOperatorAdded(value: String): Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
        }
    }

    fun onEqual(view:View){
        if(lastNumeric){
            var tvValue = textView?.text.toString()
            var prefix = ""

            try{
                if(tvValue.startsWith("-")){
                    prefix="-"
                    tvValue=tvValue.substring(1)
                }
//                if(tvValue.contains("-")){
//                    var splitValue = tvValue.split("-")
//
//                    var one = splitValue[0]
//                    var two = splitValue[1]
//
//                    if(prefix.isNotEmpty()){
//                        one = prefix + one
//                    }
//                    val result = one.toDouble() - two.toDouble()
//                    textView?.text = result.toString()
//                }

                var operator: String = ""
                var one = "1"
                var two = "2"
                for(op in arrayOf("-", "+", "*", "/")){
                    if(tvValue.contains(op)){
                        operator = op
                        var splitValue = tvValue.split(operator)

                        one = splitValue[0]
                        two = splitValue[1]
                    }
                }

                when(operator){
                    "-" -> {
                            if (prefix.isNotEmpty()) {
                                one = prefix + one
                            }
                            val result = one.toDouble() - two.toDouble()
                            removeZeroAfterDot(result.toString())
                            }
                    "+" -> {
                            val result = one.toDouble() + two.toDouble()
                        removeZeroAfterDot(result.toString())
                            }
                    "*" -> {
                            val result = one.toDouble() * two.toDouble()
                        removeZeroAfterDot(result.toString())
                            }
                    "/" -> {
                            val result:Int = (one.toDouble() / two.toDouble()).toInt()
                        removeZeroAfterDot(result.toString())
                            }


                }

            }catch (e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }

    private fun removeZeroAfterDot(result: String)
    {
        var value = result
        if(result.contains(".0")){
            value = result.substring(0, result.length-2)
        }
        textView?.text = value
    }
}