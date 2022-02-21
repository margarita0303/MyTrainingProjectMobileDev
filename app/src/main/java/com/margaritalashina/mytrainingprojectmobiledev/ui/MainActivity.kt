package com.margaritalashina.mytrainingprojectmobiledev.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.margaritalashina.mytrainingprojectmobiledev.R
import com.margaritalashina.mytrainingprojectmobiledev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewBinding by viewBinding(ActivityMainBinding::bind)
    // источник данных для activity - view модель
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //  входная точка получения contentmanager
        // supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, )


    }
}