package com.kshitijpatil.kotlinarchitect

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.kshitijpatil.kotlinarchitect.data.view.MainViewModel
import com.kshitijpatil.kotlinarchitect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var mainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.data = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.executePendingBindings()
    }
}
