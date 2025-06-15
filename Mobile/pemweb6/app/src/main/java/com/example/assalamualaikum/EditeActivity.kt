package com.example.assalamualaikum

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class EditeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitiy_profile)

        supportActionBar?.title = "Edite Profile"
    }
}
