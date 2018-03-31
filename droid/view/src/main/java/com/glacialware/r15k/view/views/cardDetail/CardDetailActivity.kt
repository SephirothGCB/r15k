package com.glacialware.r15k.view.views.cardDetail

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.wireframes.navigateTo
import com.glacialware.r15k.view.views.generic.GenericRootActivity
import com.glacialware.r15k.view.wireframes.editCard.EditCardActivityWireframe
import com.glacialware.r15k.viewmodel.views.cardDetail.CardDetailViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
* Created by Guille on 09/07/2017.
*/
class CardDetailActivity : GenericRootActivity<CardDetailViewModel>(true) {

    // ---- Dagger attributes ----
    @field:[Inject]
    protected lateinit var mWireFrame: EditCardActivityWireframe
    // ---- END Dagger attributes ----

    // ---- GenericRootActivity ----

    override fun initDI() {
        mActivityComponent.inject(this)
    }

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(CardDetailViewModel::class.java)
    }

    override fun initView() {
        this.setContentView(R.layout.activity_generic_toolbar)

        this.initToolbar()
    }

    override fun initFragment() {
        navigateTo(supportFragmentManager, CardDetailFragment.newInstance(), CardDetailFragment.TAG, R.id.frame_content, true, false)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> this.onBackPressed()
        }

        return super.onOptionsItemSelected(item)
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