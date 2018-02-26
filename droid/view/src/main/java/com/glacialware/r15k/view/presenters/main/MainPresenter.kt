package com.glacialware.r15k.view.presenters.main

import android.support.v4.widget.DrawerLayout
import android.view.View
import com.glacialware.r15k.view.presenters.GenericActivityPresenter
import com.glacialware.r15k.view.views.main.MainActivity
import com.glacialware.r15k.view.wireframes.main.MainWireframe
import com.glacialware.r15k.view.wireframes.main.MainWireframeImpl

/**
* Created by Guille on 09/07/2017.
*/
class MainPresenter(private val view : MainActivity) : GenericActivityPresenter() {
    companion object {
        private const val ADD_PLAYER : Int = 0
        private const val EDIT_CARD : Int = 1
        private const val START_GAME : Int = 2
    }

    private val wireframe : MainWireframe? = MainWireframeImpl(view as? MainActivity)

    override fun initViewModel() {
    }

    override fun initFragment() {
        wireframe?.startFragment()
    }

    fun onBackPressed() {
        if (view.isDrawerOpen()) {
            view.closeDrawer()
        } else {
            view.superOnBackPressed()
        }
    }

    fun onClick() {
        wireframe?.goToTest()
    }

    fun onItemClick(pos : Int) {
        view.closeDrawer()
        view.addDrawerListener(object: DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(newState: Int) {
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
            }

            override fun onDrawerClosed(drawerView: View) {
                when (pos) {
                    ADD_PLAYER -> wireframe?.goToAddPlayer()
                    EDIT_CARD -> wireframe?.goToEditCard()
                    START_GAME -> {}
                }
                view.removeDrawerListener(this)
            }

            override fun onDrawerOpened(drawerView: View) {
            }
        })
    }
}