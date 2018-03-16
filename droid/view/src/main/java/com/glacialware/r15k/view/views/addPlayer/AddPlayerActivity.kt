package com.glacialware.r15k.view.views.addPlayer

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.presenters.addPlayer.AddPlayerActivityPresenter
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.view.wireframes.addPlayer.AddPlayerActivityWireframe
import com.glacialware.r15k.viewmodel.views.addPlayer.AddPlayerViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
* Created by Guille on 09/07/2017.
*/
class AddPlayerActivity : GenericRootActivity(true) {

    // ---- GenericRootActivity ----

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                android.R.id.home -> this.onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(AddPlayerViewModel::class.java)
    }

    override fun initView() {
        this.setContentView(R.layout.activity_generic_toolbar)
        this.initToolbar()
    }

    override fun initPresenter() {
        mPresenter = AddPlayerActivityPresenter()
    }

    override fun initWireframe() {
        mWireFrame = AddPlayerActivityWireframe(this)
    }

    override fun initFragment() {
        mWireFrame.initFragment()
    }

    // ---- END GenericRootActivity ----

    // ---- Private ----

    private fun initToolbar() {
        if (myToolbar != null)
            this.setSupportActionBar(myToolbar as Toolbar)

        if (this.supportActionBar != null) {
            (this.supportActionBar as ActionBar).setDisplayHomeAsUpEnabled(true)
            (this.supportActionBar as ActionBar).setHomeButtonEnabled(true)
        }
    }

    // ---- END Private ----

}