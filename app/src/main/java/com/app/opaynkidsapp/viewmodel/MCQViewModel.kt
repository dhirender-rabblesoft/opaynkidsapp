package com.app.opaynkidsapp.viewmodel

import android.app.Application
import android.content.Context
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.FillBlankTestAdapter
import com.app.opaynkidsapp.adapter.MCQButtonAdapter
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityMcqactivityBinding

import com.app.opaynkidsapp.extensions.visible


class MCQViewModel(application: Application) : AppViewModel(application) {
    private lateinit var binder: ActivityMcqactivityBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity


    fun setBinder(binder: ActivityMcqactivityBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this
        setclicks()
        settoolbar()
        setAdapter()
    }

    private fun settoolbar() {
        binder.toolbar.tvtitle.setText("MCQ")
        binder.toolbar.icmenu2.visible()
        binder.toolbar.icmenu2.setImageResource(R.drawable.ic_baseline_arrow_back_24)
    }

    private fun setAdapter() {

        val listofarray = ArrayList<Char>()
        listofarray.add('A')
        listofarray.add('B')
        listofarray.add('C')
        listofarray.add('D')
        listofarray.add('E')
        listofarray.add('F')
        listofarray.add('G')

        val mcqAdapter = MCQButtonAdapter(baseActivity) {


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


            binder.toolbar.tvtitle.setText("Fill In The Blank")
            binder.tvquestion.setText("Select Right Word")



            setAdapter()


            binder.rvFillBlankButton.visible()

        }


    }


}