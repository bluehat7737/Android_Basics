package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var tvSelectedDate: TextView? = null
    private var tvSelectedDateInMinute: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvSelectedDateInMinute = findViewById(R.id.tvSelectedDateInMinutes)
        btnDatePicker.setOnClickListener{view ->
            clickDatePicker(view)
            Toast.makeText(this, "Button Working", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clickDatePicker(view: View){
        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ _, SelectedYear, selectedMonth, dayOfMonth ->
            val selectedDate = "$dayOfMonth/${selectedMonth+1}/$SelectedYear"
            tvSelectedDate?.text = selectedDate

            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)
            theDate?.let {
                val selecedDateInMinute = theDate.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                currentDate?.let {
                    val currentDtaeInMinutes = currentDate.time/60000
                    val differenceInMinutes = currentDtaeInMinutes - selecedDateInMinute
                    tvSelectedDateInMinute?.text = differenceInMinutes.toString()
                }
            }
        }
            ,year
            ,month
            ,day)

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()
    }
}