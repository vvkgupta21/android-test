package com.example.test.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.test.R
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment
//        // Get the NavController from the NavHostFragment
//        val navController = navHostFragment.navController
//
//        // Navigate to the desired fragment
//        navController.navigate(R.id.fragmentHome)
    }
}