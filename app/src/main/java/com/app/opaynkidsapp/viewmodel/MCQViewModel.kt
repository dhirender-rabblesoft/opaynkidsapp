package com.app.opaynkidsapp.viewmodel

import android.app.Application
import android.content.Context
import com.app.opaynkidsapp.MCQTestAdapter
import com.app.opaynkidsapp.R

import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityMcqactivityBinding

import com.app.opaynkidsapp.extensions.visible


class MCQViewModel(application: Application) : AppViewModel(application) {
    private lateinit var binder: ActivityMcqactivityBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    val listofarray = ArrayList<String>()
    var i = 0

    fun setBinder(binder: ActivityMcqactivityBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this
        setclicks()
        settoolbar()
        setMCQAdapter()
    }

    private fun settoolbar() {
        binder.toolbar.tvtitle.setText("MCQ")
        binder.toolbar.icmenu2.visible()
        binder.toolbar.icmenu2.setImageResource(R.drawable.ic_baseline_arrow_back_24)
    }

    private fun setMCQAdapter() {


        listofarray.add("A")
        listofarray.add("B")
        listofarray.add("C")
        listofarray.add("D")


        val mcqAdapter = MCQTestAdapter(baseActivity) {


        }
        mcqAdapter.addNewList(listofarray)
        binder.rvMcqButton.adapter = mcqAdapter

    }


    private fun setclicks() {

        binder.toolbar.icmenu2.setOnClickListener {
            baseActivity.onBackPressed()
        }

        binder.speakerlotties.setOnClickListener {
//            mp.start()
//            setAnimation()
            binder.speakerlotties.playAnimation()
        }
        binder.loginbutton.setOnClickListener {
            i++
            if (listofarray.size > i){
                binder.tvquestion.setText("Select B")
            }


        }


    }


}