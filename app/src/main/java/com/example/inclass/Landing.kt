package com.example.inclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Landing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)


    }
    fun daftar(view: View){
        val intKeDaftar = Intent(this, Signup::class.java)
        startActivity(intKeDaftar)
    }

    fun login(view: View){
        val intKeLogin = Intent(this, Login::class.java)
        startActivity(intKeLogin)
    }
}