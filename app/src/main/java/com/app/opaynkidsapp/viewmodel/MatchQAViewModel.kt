package com.app.opaynkidsapp.viewmodel

import android.app.Application
import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.ABMatchAdapterLeft
import com.app.opaynkidsapp.adapter.ABMatchAdapterRight
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.base.KotlinCanvas
import com.app.opaynkidsapp.databinding.ActivityMatchQaactivityBinding
import com.app.opaynkidsapp.extensions.isNotNull
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.listner.ItemClick
import com.app.opaynkidsapp.utils.Keys
import kotlinx.coroutines.*
import java.util.*


class MatchQAViewModel(application: Application) : AppViewModel(application), ItemClick {
    private lateinit var binder: ActivityMatchQaactivityBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    var isFlag = false
    lateinit var canvasView: KotlinCanvas
    val activityScope = CoroutineScope(Dispatchers.Main)
    var leftListAdapter: ABMatchAdapterLeft? = null
    var rightListAdapter: ABMatchAdapterRight? = null
    val leftlist: MutableList<LeftMatchListingModel> = ArrayList()
    val rightList: MutableList<RightMatchListingModel> = ArrayList()
    var sourcePosition = -1
    var targetPosition = -1


    fun setBinder(binder: ActivityMatchQaactivityBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this
        Keys.isSubmit = false
        initLeftRecyclerView()
        initRightRecyclerView()
        setcanas()
        settoolbar()


        binder.loginbutton.setOnClickListener {
            Toast.makeText(baseActivity, "You submit your test", Toast.LENGTH_LONG).show()
            Keys.isSubmit = true


            rightListAdapter?.notifyDataSetChanged()
            leftListAdapter?.notifyDataSetChanged()

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
        binder.rvAmatcher.layoutManager = LinearLayoutManager(
            baseActivity, LinearLayoutManager.VERTICAL, false
        )

        leftlist.add(LeftMatchListingModel(1, "A", 11))
        leftlist.add(LeftMatchListingModel(2, "B", 13))
        leftlist.add(LeftMatchListingModel(3, "C", 12))
        leftlist.add(LeftMatchListingModel(4, "D", 14))

        leftListAdapter = ABMatchAdapterLeft(leftlist, baseActivity) {

        }
        binder.rvAmatcher.adapter = leftListAdapter


    }

    private fun initRightRecyclerView() {
        binder.rvBMatcher!!.layoutManager = LinearLayoutManager(
            baseActivity, LinearLayoutManager.VERTICAL, false
        )

        rightList.add(RightMatchListingModel(11, "A"))
        rightList.add(RightMatchListingModel(12, "C"))
        rightList.add(RightMatchListingModel(13, "B"))
        rightList.add(RightMatchListingModel(14, "D"))


        rightListAdapter = ABMatchAdapterRight(rightList, baseActivity)
        binder.rvBMatcher.adapter = rightListAdapter

//        binder.rvBMatcher.setOnDragListener(bottomListAdapter.dragInstance)
    }


    override fun onItemViewClickedLeft(startx: Float, starty: Float) {

        val point = Point(startx.toInt(), starty.toInt())
        val convertedApoint = convertPoint(point, binder.matchcontainer, binder.rvAmatcher)
        val leftchild =
            binder.rvAmatcher.findChildViewUnder(
                convertedApoint!!.x.toFloat(),
                convertedApoint.y.toFloat()
            )



        if (leftchild.isNotNull()) {
            val pos = binder.rvAmatcher.getChildAdapterPosition(leftchild!!)
            sourcePosition = pos

            if (leftlist[sourcePosition].selectedID.equals(-1)) {
                Keys.startpoint = true
            } else {
                Keys.startpoint = false
            }



            rightListAdapter?.notifyDataSetChanged()
//            Log.e("childpositon", binder.rvAmatcher.getChildAdapterPosition(child!!).toString())
//            Log.e("childpositon", leftlist[pos].name.toString())
        }
    }

    override fun onItemViewClickedRight(endx: Float, endy: Float) {


        val point = Point(endx.toInt(), endy.toInt())
        val convertedpoint = convertPoint(point, binder.matchcontainer, binder.rvBMatcher)

        val rightchild = binder.rvBMatcher.findChildViewUnder(
            convertedpoint!!.x.toFloat(),
            convertedpoint.y.toFloat()
        )

        if (rightchild.isNotNull()) {

            val positon = binder.rvBMatcher.getChildAdapterPosition(rightchild!!)
            targetPosition = positon

            var badaptername = rightList[positon].name


//                if (!leftlist[sourcePosition].selectedID.equals(rightList[targetPosition].id)){
//                    Keys.endpoint = true
//                }else{
//                    Keys.endpoint = false
//                }

            

            leftlist.forEach {

                if (it.selectedID.equals(-1)) {
                    leftlist[sourcePosition].selectedID = rightList[positon].id
                }

                if (it.selectedID.equals(rightList[positon].id)) {


//                    Keys.endpoint = false
                } else {
                    Log.e("endtaskselection B - ", "BBBBBBBBBBB")

                    Keys.endpoint = true

                }
            }

            if (leftlist[sourcePosition].selectedID.equals(leftlist[sourcePosition].answerID)) {
                rightList[targetPosition].isRight = true
                rightListAdapter?.notifyDataSetChanged()
            }
            leftListAdapter?.notifyDataSetChanged()


            Log.e("8156971526", leftlist.toString())

//            Log.e(
//                "b adatper value ",
//                binder.rvBMatcher.getChildAdapterPosition(child2!!).toString()
//            )
//            Log.e("childpositon posotuion ", rightList[positon].name.toString())
        }

    }


    //converted screen x and y point accroding to recycler view x and y point like screen point (35,35) and recycvlver view point(125,125)  so its convert the start point (35,35 ) to  x,y (125,125)
    fun convertPoint(
        fromPoint: Point,
        fromView: View,
        toView: View
    ): Point? {
        val fromCoord = IntArray(2)
        val toCoord = IntArray(2)
        fromView.getLocationOnScreen(fromCoord)
        toView.getLocationOnScreen(toCoord)
        return Point(
            fromCoord[0] - toCoord[0] + fromPoint.x,
            fromCoord[1] - toCoord[1] + fromPoint.y
        )
    }


}