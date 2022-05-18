package com.app.opaynkidsapp.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.ABMatchAdapter
import com.app.opaynkidsapp.adapter.ABMatchAdapter2
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.CanvasDraw2
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityMatchQaactivityBinding
import com.app.opaynkidsapp.extensions.gone
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.listner.Listener
import com.app.opaynkidsapp.ui.HomeScreen
import com.app.opaynkidsapp.utils.Keys
import kotlinx.coroutines.*
import java.util.*
import java.util.logging.Handler
import kotlin.collections.ArrayList


class MatchQAViewModel(application: Application) : AppViewModel(application), Listener {
    private lateinit var binder: ActivityMatchQaactivityBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    var isFlag = false
    lateinit var canvasView: CanvasDraw2
    val activityScope = CoroutineScope(Dispatchers.Main)
    var topListAdapter:ABMatchAdapter? = null
    var bottomListAdapter:ABMatchAdapter2? = null

    fun setBinder(binder: ActivityMatchQaactivityBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this

        initLeftRecyclerView()
        initRightRecyclerView()
        setcanas()
        settoolbar()
        binder.loginbutton.setOnClickListener {
            Toast.makeText(baseActivity,"You submit your test",Toast.LENGTH_LONG).show()
            Keys.isSubmit = true
            topListAdapter?.notifyDataSetChanged()
            bottomListAdapter?.notifyDataSetChanged()
        }
    }
    private fun settoolbar(){
        binder.toolbar.tvtitle.setText("Drag and Drop")
        binder.toolbar.icmenu2.visible()
        binder.toolbar.icmenu2.setImageResource(R.drawable.ic_baseline_arrow_back_24)
        binder.toolbar.icmenu2.setOnClickListener {
            Keys.isSubmit = false
            baseActivity.onBackPressed()
        }
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
          topListAdapter = ABMatchAdapter(leftlist, this, baseActivity){
//            if (leftlist[it].ans.equals(0)){
//                binder.animContianer.visibility =View.VISIBLE
//                binder.crylottiesanim.playAnimation()
//
//                activityScope.launch {
//                    delay(1500)
//                    binder.animContianer.visibility =View.GONE
//                    binder.crylottiesanim.resumeAnimation()
//                }
//            }

        }
        binder.rvAmatcher!!.adapter = topListAdapter

        binder.rvAmatcher!!.setOnDragListener(topListAdapter?.dragInstance)


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

         bottomListAdapter = ABMatchAdapter2(rightList, this, baseActivity)
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