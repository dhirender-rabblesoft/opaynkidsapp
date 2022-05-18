package com.app.opaynkidsapp.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.FillBlankTestAdapter
import com.app.opaynkidsapp.adapter.MCQButtonAdapter
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityFillBlankBinding
import com.app.opaynkidsapp.databinding.ActivityForgotPasswordBinding
import com.app.opaynkidsapp.extensions.hideKeyboard
import com.app.opaynkidsapp.extensions.isEmailValid
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.ui.OTPVerify


class FillBlankTestViewModel(application: Application) : AppViewModel(application) {
    private lateinit var binder: ActivityFillBlankBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    var isFlag = false
    val addlistarrray = ArrayList<Char>()
    var fillbankAdapter: FillBlankTestAdapter? = null

    fun setBinder(binder: ActivityFillBlankBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this
        setclicks()
        setAdapter()
        settoolbar()
        setFillBlankAdapter()

    }

    private fun settoolbar() {
        binder.toolbar.tvtitle.setText("Fill In The Blanks")
        binder.toolbar.icmenu2.visible()
        binder.toolbar.icmenu2.setImageResource(R.drawable.ic_baseline_arrow_back_24)
        binder.toolbar.icmenu2.setOnClickListener {
            baseActivity.onBackPressed()
        }
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
            Log.e("createnew123",addlistarrray.toString())
            val getWord = listofarray[it]
            val ans = "apple"
            if (addlistarrray.size <= ans.length) {
                Log.e("createnew3333",addlistarrray.toString())
                addlistarrray.add(getWord)
                Log.e("createnew4444",addlistarrray.toString())
                setFillBlankAdapter()
            } else {
                Toast.makeText(baseActivity, "No space left to fill words", Toast.LENGTH_LONG)
                    .show()
            }

            fillbankAdapter?.notifyDataSetChanged()

        }
        mcqAdapter.addNewList(listofarray)
        binder.rvMcqButton.adapter = mcqAdapter

    }

    private fun setFillBlankAdapter() {


        fillbankAdapter = FillBlankTestAdapter(addlistarrray, baseActivity) {


        }

//        fillbankAdapter?.addNewList(addlistarrray)
        binder.rvFillBlankButton.adapter = fillbankAdapter

    }

    private fun setclicks() {
        binder.loginbutton.setOnClickListener {
            setFillBlankAdapter()
            fillbankAdapter?.notifyDataSetChanged()
        }

    }


}