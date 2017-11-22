package com.glacialware.r15k.view.presenters.addPlayer

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.glacialware.r15k.view.Components.CustomToast
import com.glacialware.r15k.view.R
import com.glacialware.r15k.view.databinding.FragmentAddPlayerBinding
import com.glacialware.r15k.view.di.CustomToastComponent
import com.glacialware.r15k.view.di.CustomToastModule
import com.glacialware.r15k.view.di.DaggerCustomToastComponent
import com.glacialware.r15k.view.presenters.GenericFragmentPresenter
import com.glacialware.r15k.view.views.addPlayer.AddPlayerFragment
import com.glacialware.r15k.viewmodel.views.addPlayer.AddPlayerViewModel
import javax.inject.Inject

/**
 * Created by Guille on 20/11/2017.
 */
class AddPlayerFragmentPresenter(private val view: AddPlayerFragment) : GenericFragmentPresenter() {
    private val mCustomToastComponent: CustomToastComponent by lazy {
        DaggerCustomToastComponent
                .builder()
                .customToastModule(CustomToastModule(view.activity))
                .build()
    }

    @field:[Inject]
    lateinit var mCustomToast : CustomToast

    private var viewModel : AddPlayerViewModel? = null

    private var binding : FragmentAddPlayerBinding? = null

    override fun initViewModel(inflater: LayoutInflater, container: ViewGroup): View? {// dagger
        mCustomToastComponent.inject(this)
        // ----
        // view model
        viewModel = ViewModelProviders.of(view.activity).get(AddPlayerViewModel::class.java)
        if (viewModel != null) {
            viewModel?.setToast(mCustomToast)
            view.lifecycle.addObserver(viewModel!!)
            // ----
            // data binding
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_player, container, false)
            if (binding != null) {
                binding?.viewModel = viewModel
                // ----
                return binding?.root
            }
        }

        return null
    }
}