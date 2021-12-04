package com.example.agetominutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_main)
        /*This is implemented by android studio it self when we select the Basic Activity while creating the project.*/
        setSupportActionBar(toolbar)


    }
}