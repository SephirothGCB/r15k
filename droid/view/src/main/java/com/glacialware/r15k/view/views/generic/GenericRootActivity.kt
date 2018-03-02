package com.glacialware.r15k.view.views.generic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.glacialware.r15k.RiskApplication
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.views.di.GenericActivityComponent
import com.glacialware.r15k.view.views.di.GenericActivityModule
import com.glacialware.r15k.view.wireframes.navigateBackAnimated

/**
* Created by Guille on 04/07/2017.
*/
abstract class GenericRootActivity constructor(private var anim: Boolean = false) : AppCompatActivity() {

    // ---- Attributes ----

    var mComponent: GenericActivityComponent? = null

    // ---- END Attributes ----

    // ---- Activity -----

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (anim) {
            this.overridePendingTransition(R.anim.slide_in_enter, R.anim.slide_out_enter)
        }

        // It is mandatory to initialize the view model before de view:
        // 0. Init dagger.
        // 1. View model.
        // 2. View.
        // 3. Fragment.
        // All activities have, at least, one fragment.
        this.initDI()
        this.initViewModel()
        this.initView()
        this.initFragment()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (anim && this.supportFragmentManager.backStackEntryCount == 0) {
            navigateBackAnimated(this)
        }
    }

    // ---- END Activity ----

    // ---- Abstract ----

    abstract fun initFragment()
    abstract fun initViewModel()
    abstract fun initView()

    // ---- END Abstract ----

    // ---- Protected ----

    protected fun isCreated() : Boolean = !isFinishing && !isDestroyed

    // ---- END Protected ----

    // ---- Private ----

    private fun initDI() {
        mComponent = (application as RiskApplication?)?.applicationComponent?.with(GenericActivityModule())
        mComponent?.inject(this)
    }

    // ---- END Private ----
}