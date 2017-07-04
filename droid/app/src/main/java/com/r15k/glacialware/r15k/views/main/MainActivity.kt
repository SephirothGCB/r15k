package com.r15k.glacialware.r15k.views.main

import android.os.Bundle
import com.r15k.glacialware.r15k.ddbb.DbManager
import com.r15k.glacialware.r15k.views.generic.GenericRootActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Guille on 01/07/2017.
 */
class MainActivity : GenericRootActivity() {
    lateinit var dbManager : DbManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setContentView(com.r15k.glacialware.r15k.R.layout.activity_main)

        this.init()
        this.initDB()
    }

    override fun onDestroy() {
        dbManager.close()

        super.onDestroy()
    }

    private fun init() {
        textView.text = "preparing view... be patient... don't worry, be happy :D :D"
    }

    private fun initDB() {
        dbManager = DbManager(this)
        dbManager.saveMission(
                "Mission test",
                "This is my first mission",
                "",
                true
        )
    }
}