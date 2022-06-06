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
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.model.ModelClass
import com.app.opaynkidsapp.repository.CommonRepository
import com.app.opaynkidsapp.utils.Keys
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList


class FillBlankTestViewModel(application: Application) : AppViewModel(application) {
    private lateinit var binder: ActivityFillBlankBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    var isFlag = false
    var commonRepository=CommonRepository(application)
    val addlistarrray = ArrayList<String>()
    val shufflelist = ArrayList<ModelClass>()
    var fillbankAdapter: FillBlankTestAdapter? = null
    var ans=""
    var tempfilledlist=ArrayList<String>()
    var filledpo=0

    fun setBinder(binder: ActivityFillBlankBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this
        setclicks()

        settoolbar()

        callapi()

    }

    private fun settoolbar() {
        binder.toolbar.tvtitle.setText("Fill In The Blanks")
        binder.toolbar.icmenu2.visible()
        binder.toolbar.icmenu2.setImageResource(R.drawable.ic_baseline_arrow_back_24)
        binder.toolbar.icmenu2.setOnClickListener {
            baseActivity.onBackPressed()
        }
    }
    private  fun  callapi()
    {

        commonRepository.fillup(baseActivity,Keys.FILLUP)
        {
           ans=it.data[0].answer
         val   incorrectans=it.data[0].incorrect_answer
            val ch = CharArray(ans.length)
            val inch = CharArray(ans.length)
            for (i in 0 until ans.length) {

                addlistarrray.add("")
            }
            for (i in 0 until incorrectans.length) {
                shufflelist.add(ModelClass(incorrectans[i].toString(),isclick = false))
             }

            setFillBlankAdapter()
            setAdapter()
            Picasso.get().load(it.data[0].image).placeholder(R.drawable.progress_animation).into(binder.ivQuesImg)
        }
    }



    private fun setAdapter() {


        var tempshufflelist=shufflelist.shuffled()
        val mcqAdapter = MCQButtonAdapter(baseActivity) {
            Log.e("createnew123",addlistarrray.toString())
            //val getWord = listofarray[it]

            if (tempfilledlist.size <= ans.length-1) {
                Log.e("createnew3333",addlistarrray.toString())
                tempfilledlist.add(tempshufflelist[it].name)
                addlistarrray[filledpo]=tempshufflelist[it].name
              // addlistarrray.add(tempshufflelist[it])
                ++filledpo
                Log.e("createnew4444",addlistarrray.toString())
                setFillBlankAdapter()
            } else {
                Toast.makeText(baseActivity, "No space left to fill words", Toast.LENGTH_LONG)
                    .show()
            }

            fillbankAdapter?.notifyDataSetChanged()

        }
        mcqAdapter.addNewList(tempshufflelist)
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
            Log.e("templist",tempfilledlist.size.toString())
//            setFillBlankAdapter()
//            fillbankAdapter?.notifyDataSetChanged()
        }

    }


}