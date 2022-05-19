package com.app.opaynkidsapp.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.ABMatchAdapter
import com.app.opaynkidsapp.adapter.ABMatchAdapter2
import com.app.opaynkidsapp.adapter.RecyclerTouchListener
import com.app.opaynkidsapp.adapter.RecyclerTouchListener.ClickListener
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.CanvasDraw2
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.base.KotlinCanvas
import com.app.opaynkidsapp.databinding.ActivityMatchQaactivityBinding
import com.app.opaynkidsapp.extensions.isNotNull
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.listner.ItemClick

import com.app.opaynkidsapp.listner.Listener
import com.app.opaynkidsapp.utils.Keys
import kotlinx.coroutines.*
import java.util.*


class MatchQAViewModel(application: Application) : AppViewModel(application), Listener, ItemClick {
    private lateinit var binder: ActivityMatchQaactivityBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    var isFlag = false
    lateinit var canvasView: KotlinCanvas
    val activityScope = CoroutineScope(Dispatchers.Main)
    var topListAdapter: ABMatchAdapter? = null
    var bottomListAdapter: ABMatchAdapter2? = null
    var startx = 0f
    var starty = 0f
    var endx = 0f
    var endy = 0f


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
            Toast.makeText(baseActivity, "You submit your test", Toast.LENGTH_LONG).show()
            Keys.isSubmit = true
            topListAdapter?.notifyDataSetChanged()
            bottomListAdapter?.notifyDataSetChanged()
        }
    }

    private fun settoolbar() {
        binder.toolbar.tvtitle.setText("Drag and Drop")
        binder.toolbar.icmenu2.visible()
        binder.toolbar.icmenu2.setImageResource(R.drawable.ic_baseline_arrow_back_24)
        binder.toolbar.icmenu2.setOnClickListener {
            Keys.isSubmit = false
            baseActivity.onBackPressed()
        }
    }

    private fun setcanas() {
        canvasView = KotlinCanvas(baseActivity, this)
        canvasView.mwidth = 50
        canvasView.mheight = 50
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
        topListAdapter = ABMatchAdapter(leftlist, this, baseActivity) {


            val child =
                binder.rvAmatcher.findChildViewUnder(startx, starty)


                if (child.isNotNull()) {
                    val pos = binder.rvAmatcher.getChildAdapterPosition(child!!)

                    Log.e(
                        "childpositon",
                        binder.rvAmatcher.getChildAdapterPosition(child!!).toString()
                    )
                    Log.e("childpositon", leftlist[pos].name.toString())
                }


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

    override fun onItemViewClicked(startx: Float, starty: Float) {

        Log.e("checkstartxy", "startx  $startx start y  $starty")
        this.startx = startx
        this.starty = starty

    }

    override fun onItemViewClicked2(endx: Float, endy: Float) {
        Log.e("checkstartxy", "endx  $endx end y  $endy")
        this.endx = endx
        this.endy = endy

    }


}