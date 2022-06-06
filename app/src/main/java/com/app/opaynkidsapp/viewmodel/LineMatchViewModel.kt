package com.app.opaynkidsapp.viewmodel
import android.app.Application
import android.content.Context
import android.graphics.Point
import android.os.Build
import android.speech.tts.TextToSpeech
import android.speech.tts.Voice
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
import com.app.opaynkidsapp.databinding.ActivityLineMatchingBinding
import com.app.opaynkidsapp.databinding.ActivityMatchQaactivityBinding
import com.app.opaynkidsapp.extensions.isNotNull
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.listner.ItemClick
import com.app.opaynkidsapp.model.LeftMatchListingModel
import com.app.opaynkidsapp.model.RightMatchListingModel
import com.app.opaynkidsapp.repository.CommonRepository
import com.app.opaynkidsapp.utils.Keys
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.w3c.dom.Text
import java.util.*
class LineMatchViewModel (application: Application) : AppViewModel(application), ItemClick {
    private lateinit var binder: ActivityLineMatchingBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    var commonRepository: CommonRepository = CommonRepository(application)
    var isFlag = false
    lateinit var canvasView: KotlinCanvas
     var leftListAdapter: ABMatchAdapterLeft? = null
    var rightListAdapter: ABMatchAdapterRight? = null
    val leftlist: MutableList<LeftMatchListingModel> = ArrayList()
    val rightList: MutableList<RightMatchListingModel> = ArrayList()
    var sourcePosition = -1
    var targetPosition = -1
    var textToSpeech: TextToSpeech? = null


    fun setBinder(binder: ActivityLineMatchingBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this
        Keys.isSubmit = false


        setcanas()
        settoolbar()
        initTextToSpeach()
        getmatches()


        binder.loginbutton.setOnClickListener {
            Toast.makeText(baseActivity, "You submit your test", Toast.LENGTH_LONG).show()
            Keys.isSubmit = true
            rightListAdapter?.notifyDataSetChanged()
            leftListAdapter?.notifyDataSetChanged()
        }
    }

    private fun settoolbar() {
        binder.toolbar.tvtitle.text = baseActivity.getString(R.string.matching_test)
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

        leftListAdapter = ABMatchAdapterLeft(leftlist, baseActivity) {

        }
        binder.rvAmatcher.adapter = leftListAdapter


    }
    private  fun getmatches()
    {
        commonRepository.match(baseActivity,Keys.MATCHES){
            if (it.data.question.size>0)
            {
                it.data.question.forEach {
                    leftlist.add(LeftMatchListingModel(it.id.toInt(), it.question, it.answer_id.toInt()))

                }

                initLeftRecyclerView()
            }
            if (it.data.answer.size>0)
            {
                it.data.answer.forEach {
                    rightList.add(RightMatchListingModel(it.id.toInt(), R.drawable.apple, it.answer))
                }
                initRightRecyclerView()
            }
        }
    }

    private fun initRightRecyclerView() {
        binder.rvBMatcher.layoutManager = LinearLayoutManager(
            baseActivity, LinearLayoutManager.VERTICAL, false)
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

            val selectedname = leftlist[pos].name
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                textToSpeech?.speak(selectedname, TextToSpeech.QUEUE_FLUSH, null, null)

            } else {
                textToSpeech?.speak(selectedname, TextToSpeech.QUEUE_FLUSH, null)
            }



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

            if (sourcePosition != -1) {
                val positon = binder.rvBMatcher.getChildAdapterPosition(rightchild!!)
                targetPosition = positon


                var badaptername = rightList[positon].name


//                if (!leftlist[sourcePosition].selectedID.equals(rightList[targetPosition].id)){
//                    Keys.endpoint = true
//                }else{
//                    Keys.endpoint = false
//                }


                // set voice on right hand side
//                val selectedname = rightList[positon].name
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    textToSpeech?.speak(selectedname, TextToSpeech.QUEUE_FLUSH, null, null)
//
//                } else {
//                    textToSpeech?.speak(selectedname, TextToSpeech.QUEUE_FLUSH, null)
//                }
                //==============end set voice right hand side ================//


                if (!rightList[positon].isSelect) {


                    leftlist.forEach {

                        if (it.selectedID.equals(-1)) {


                            leftlist[sourcePosition].selectedID = rightList[positon].id
                            rightList[positon].isSelect = true


                        }

                        if (it.selectedID.equals(rightList[positon].id)) {


//                    Keys.endpoint = false
                        } else {
                            Log.e("endtaskselection B - ", "BBBBBBBBBBB")
                            Keys.endpoint = true

                        }
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
            } else {
                Toast.makeText(baseActivity, "First Selected Right hand", Toast.LENGTH_LONG).show()
            }
        }

    }


    private fun initTextToSpeach() {
        //text to speak
        textToSpeech = TextToSpeech(baseActivity, object : TextToSpeech.OnInitListener {
            override fun onInit(status: Int) {
                if (status != TextToSpeech.ERROR) {

//                    textToSpeech?.setLanguage(Locale.UK);

                    textToSpeech?.setLanguage(Locale("hin", "IND"));
                }
            }

        })
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