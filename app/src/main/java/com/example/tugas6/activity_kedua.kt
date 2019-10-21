package com.example.tugas6

import android.annotation.TargetApi
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class activity_kedua : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kedua)

        var intent = intent
        val title = intent.getStringExtra("title")
        val directed = intent.getStringExtra("directed")
        val home = intent.getStringExtra("home")
        val genre=intent.getStringExtra("Genre")
        val umur=intent.getStringExtra("umur")
        val negara = intent.getStringExtra("Negara")
        val tanggal = intent.getStringExtra("tanggal")

        val tampil = findViewById<TextView>(R.id.tampil)

        tampil.text= "TITLE : "+title+
                "\nDIRECTED : "+directed+
                "\nHOME PRODUCTION :"+home+
                "\nGENRE :"+genre+
                "\nAGE :"+umur+
                "\nCOUNTRY:"+negara+
                "\nDATE RELEASE : "+tanggal
    }
}


