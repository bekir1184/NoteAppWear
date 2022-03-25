package com.beko.noteappwear.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.beko.noteappwear.databinding.ActivityContentBinding

class Content : Activity() {

    private lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")

        binding.title.text = title
        binding.content.text = content


    }
}