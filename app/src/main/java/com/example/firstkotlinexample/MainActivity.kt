package com.example.firstkotlinexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        private var counter: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myBtn.setOnClickListener(myListener)
    }

    private val myListener: View.OnClickListener = View.OnClickListener {
        counter++
        myTv.text = "clicked $counter"
    }
}