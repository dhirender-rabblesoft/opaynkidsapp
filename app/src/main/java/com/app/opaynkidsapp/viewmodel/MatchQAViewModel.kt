package com.app.opaynkidsapp.viewmodel

import android.app.Application
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.opaynkidsapp.adapter.ABMatchAdapter
import com.app.opaynkidsapp.adapter.ABMatchAdapter2
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.CanvasDraw2
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityMatchQaactivityBinding
import com.app.opaynkidsapp.listner.Listener


class MatchQAViewModel(application: Application) : AppViewModel(application), Listener {
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

        initLeftRecyclerView()
        initRightRecyclerView()
        setcanas()
        settoolbar()
    }
    private fun settoolbar(){
        binder.toolbar.tvtitle.setText("Drag and Drop")
    }

    private fun setcanas() {
        canvasView = CanvasDraw2(baseActivity)
        canvasView.width = 50
        canvasView.height = 50
        binder.drawcanavs.addView(canvasView)
    }


    private fun initLeftRecyclerView() {
        binder.rvAmatcher!!.layoutManager = LinearLayoutManager(
            baseActivity, LinearLayoutManager.VERTICAL, false
        )
        val leftlist: MutableList<MatchListingModel> = ArrayList()
        leftlist.add(MatchListingModel('A'))
        leftlist.add(MatchListingModel('B'))
        leftlist.add(MatchListingModel('C'))
        leftlist.add(MatchListingModel('D'))
        val topListAdapter = ABMatchAdapter(leftlist, this, baseActivity)
        binder.rvAmatcher!!.adapter = topListAdapter

        binder.rvAmatcher!!.setOnDragListener(topListAdapter.dragInstance)
    }

    private fun initRightRecyclerView() {
        binder.rvBMatcher!!.layoutManager = LinearLayoutManager(
            baseActivity, LinearLayoutManager.VERTICAL, false
        )
        val rightList: MutableList<MatchListingModel> = ArrayList()
        rightList.add(MatchListingModel('A'))
        rightList.add(MatchListingModel('B'))
        rightList.add(MatchListingModel('C'))
        rightList.add(MatchListingModel('D'))

        val bottomListAdapter = ABMatchAdapter2(rightList, this, baseActivity)
        binder.rvBMatcher.adapter = bottomListAdapter
//        binder.rvBMatcher.setOnDragListener(bottomListAdapter.dragInstance)
    }


    companion object {
        var startx = null;
        var starty = null;
        var endx = null;
        var endy = null;
    }

    override fun setEmptyListTop(visibility: Boolean) {
         binder.rvAmatcher?.setVisibility(if (visibility) View.GONE else View.VISIBLE)

    }

    override fun setEmptyListBottom(visibility: Boolean) {
        binder.rvBMatcher?.setVisibility(if (visibility) View.GONE else View.VISIBLE)

    }

    override fun setpostion(position: Boolean) {
    }

}