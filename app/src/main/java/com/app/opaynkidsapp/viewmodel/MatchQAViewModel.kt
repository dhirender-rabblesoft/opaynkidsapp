package com.app.opaynkidsapp.viewmodel

import android.app.Application
import android.content.Context
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.AmatchAdapter
import com.app.opaynkidsapp.adapter.DragManageAdapter
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityFillBlankBinding
import com.app.opaynkidsapp.databinding.ActivityForgotPasswordBinding
import com.app.opaynkidsapp.databinding.ActivityMatchQaactivityBinding
import com.app.opaynkidsapp.extensions.hideKeyboard
import com.app.opaynkidsapp.extensions.isEmailValid
import com.app.opaynkidsapp.ui.OTPVerify


class MatchQAViewModel(application: Application) : AppViewModel(application) {
    private lateinit var binder: ActivityMatchQaactivityBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    var isFlag = false

    fun setBinder(binder: ActivityMatchQaactivityBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this
        setclicks()
        setAadapter()
    }

    private fun setAadapter() {
        val list = ArrayList<String>()
        list.add("Apple")
        list.add("Egg")
        list.add("Orange")
        list.add("Banana")
        val manager = LinearLayoutManager(baseActivity)
        binder.rvAmatcher.layoutManager = manager

        val aMatchAdapter = AmatchAdapter(baseActivity) {
        }

        aMatchAdapter.addNewList(list)
        binder.rvAmatcher.adapter = aMatchAdapter

        val dividerItemDecoration = DividerItemDecoration(baseActivity , manager.orientation)
        binder.rvAmatcher.addItemDecoration(dividerItemDecoration)

        // Setup ItemTouchHelper
        val callback = DragManageAdapter(aMatchAdapter, baseActivity,
            ItemTouchHelper.UP.or(ItemTouchHelper.DOWN), ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT))
        val helper = ItemTouchHelper(callback)
        helper.attachToRecyclerView(binder.rvAmatcher)
    }

    private fun setclicks() {

    }


}