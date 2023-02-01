package com.example.myapplication56

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    var conter=0
    var pref: SharedPreferences?=null
    lateinit var button:Button
    lateinit var button2:Button
    lateinit var res:TextView
//    private var counter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        pref=getSharedPreferences("Table", Context.MODE_PRIVATE)
        conter = pref?.getInt("key1", 0)!!
//        res.text =conter.toString()
        button = findViewById(R.id.button2)
        button2 = findViewById(R.id.button3)
        res = findViewById(R.id.textView)
        button.setOnClickListener{res.setText("${++conter}")}.toString()
        button2.setOnClickListener{res.setText("${--conter}")}.toString()
    }

    fun am(view: View) {
        conter++
        res.text=conter.toString()
    }
    fun saveData(resultat: Int){
        val editor=pref?.edit()
        editor?.putInt("key1", resultat)
        editor?.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveData(conter)
    }
}