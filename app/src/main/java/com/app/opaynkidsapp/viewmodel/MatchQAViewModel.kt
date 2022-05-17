package com.app.opaynkidsapp.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.opaynkidsapp.adapter.AmatchAdapter
import com.app.opaynkidsapp.adapter.BmatchAdapter
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.CanvasDraw
import com.app.opaynkidsapp.base.CanvasDraw2
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityMatchQaactivityBinding
import com.app.opaynkidsapp.listner.CanvasListner
import com.app.opaynkidsapp.utils.Keys
import kotlinx.android.synthetic.main.activity_draw_practice.*


class MatchQAViewModel(application: Application) : AppViewModel(application) {
    private lateinit var binder: ActivityMatchQaactivityBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    var isFlag = false
    lateinit var canvasView: CanvasDraw2


    fun setBinder(binder: ActivityMatchQaactivityBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this

        setAadapter()
        setBadapter()
        setcanas()
    }

    private fun setcanas() {
        canvasView = CanvasDraw2(baseActivity)
        canvasView.width = 50
        canvasView.height = 50
        binder.drawcanavs.addView(canvasView)
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
            val a = list[it]
            canvasView.startTouch(Keys.startx, Keys.starty)
            Log.e("dfsdfsdfdsfsd", a.toString())
        }

        aMatchAdapter.addNewList(list)
        binder.rvAmatcher.adapter = aMatchAdapter
        val r = binder.rvAmatcher.findChildViewUnder(0.5f, 1.2844f)
        Log.e("eeeeeeeeeeeerrrrr", r.toString())


    }

    private fun setBadapter() {
        val list = ArrayList<String>()
        list.add("Apple")
        list.add("Egg")
        list.add("Orange")
        list.add("Banana")

        val manager = LinearLayoutManager(baseActivity)
        binder.rvBMatcher.layoutManager = manager

        val bMatchAdapter = BmatchAdapter(baseActivity) {
            val b = list[it]
            canvasView.addtargetline(Keys.endx, Keys.endy)
            Log.e("d55555555555", b.toString())
        }

        bMatchAdapter.addNewList(list)
        binder.rvBMatcher.adapter = bMatchAdapter


    }




    companion object {
        var startx = null;
        var starty = null;
        var endx = null;
        var endy = null;
    }

}