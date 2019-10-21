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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textview_date: TextView? = null
        var cal = Calendar.getInstance()

        lateinit var cb_thriller : CheckBox
        lateinit var cb_comedy : CheckBox
        lateinit var cb_horor : CheckBox
        lateinit var cb_romance : CheckBox
        lateinit var cb_action : CheckBox
        lateinit var cb_fantasy : CheckBox

        lateinit var rb_under13 : RadioButton
        lateinit var rb_1319 : RadioButton
        lateinit var rb_above19 : RadioButton

        lateinit var negara : Spinner

        @RequiresApi(Build.VERSION_CODES.N)
        @TargetApi(Build.VERSION_CODES.N)

        textview_date = this.tanggal


        textview_date!!.text = "Date Release"

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }

            private fun updateDateInView() {
                val myFormat = "MM/dd/yyyy" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                textview_date!!.text = sdf.format(cal.getTime())
            }
        }

        textview_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    this@MainActivity,
                    dateSetListener,

                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()

            }
        })
        val judul =  findViewById<EditText>(R.id.txt_judul)
        val direksi =  findViewById<EditText>(R.id.txt_directed)
        val produksi =  findViewById<EditText>(R.id.txt_home)
        val tanggal = findViewById<TextView>(R.id.tanggal)
        val button = findViewById<Button>(R.id.btn_proccess)

        cb_thriller = findViewById(R.id.cb_thriller) as CheckBox
        cb_comedy = findViewById(R.id.cb_comedy) as CheckBox
        cb_horor = findViewById(R.id.cb_horor) as CheckBox
        cb_romance = findViewById(R.id.cb_romance) as CheckBox
        cb_action = findViewById(R.id.cb_action) as CheckBox
        cb_fantasy = findViewById(R.id.cb_fantasy) as CheckBox

        rb_under13 = findViewById(R.id.rb_under13) as RadioButton
        rb_1319 = findViewById(R.id.rb_1318) as RadioButton
        rb_above19 = findViewById(R.id.rb_above19) as RadioButton
        negara = findViewById(R.id.negara) as Spinner

        var neg = negara.getSelectedItem().toString()

        var spinner_pos = negara.getSelectedItemPosition()

        btn_proccess.setOnClickListener {
            val title = txt_judul.text.toString()
            val directed = txt_directed.text.toString()
            val home = txt_home.text.toString()
            var genre=""
            var umur=""
            var negara= negara.getSelectedItem().toString()
            val tanggal = tanggal.text.toString()

            if (cb_action.isChecked)
                genre+="Action"
            if (cb_fantasy.isChecked)
                genre+="Fantasy"
            if (cb_comedy.isChecked)
                genre+="Comedy"
            if (cb_horor.isChecked)
                genre+="Horor"
            if (cb_romance.isChecked)
                genre+="Romance"
            if (cb_thriller.isChecked)
                genre+="Thriler"

            if(rb_under13.isChecked)
                umur+="Under 13th"
            if(rb_1319.isChecked)
                umur+="13th until 19 th"
            if(rb_above19.isChecked)
                umur+="above 19 th"

            val intent = Intent (this@MainActivity, activity_kedua::class.java)
            intent.putExtra("title", title)
            intent.putExtra("directed", directed)
            intent.putExtra("home", home)
            intent.putExtra("Genre",genre)
            intent.putExtra("Umur",umur)
            intent.putExtra("Negara",negara)
            intent.putExtra("tanggal",tanggal)
            startActivity(intent)


        }

    }
}
