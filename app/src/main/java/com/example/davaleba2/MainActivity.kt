package com.example.davaleba2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Home = Home()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, Home).commit()
    }
}