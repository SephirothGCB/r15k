package com.r15k.glacialware.r15k.views.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Guille on 01/07/2017.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(com.r15k.glacialware.r15k.R.layout.activity_main)

        textView.text = "your mother is a fucker"

    }

}