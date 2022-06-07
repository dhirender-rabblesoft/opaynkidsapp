package com.app.opaynkidsapp.ui

 import android.animation.Animator
 import android.app.Application
 import android.os.Build
 import android.os.Bundle
 import android.speech.tts.TextToSpeech
 import android.util.Log
 import android.view.SoundEffectConstants
 import android.view.View
 import androidx.appcompat.app.AppCompatActivity
 import androidx.recyclerview.widget.LinearLayoutManager
 import com.app.opaynkidsapp.R
 import com.app.opaynkidsapp.adapter.DragDropAdapter
 import com.app.opaynkidsapp.applications.KidsApplication
 import com.app.opaynkidsapp.base.KotlinBaseActivity
 import com.app.opaynkidsapp.extensions.gone
 import com.app.opaynkidsapp.extensions.visible
 import com.app.opaynkidsapp.listner.DragDropCheckListner
 import com.app.opaynkidsapp.listner.Listener
 import com.app.opaynkidsapp.model.ModelClass
 import com.app.opaynkidsapp.repository.CommonRepository
 import com.app.opaynkidsapp.utils.Keys
 import com.squareup.picasso.Picasso
 import kotlinx.android.synthetic.main.activity_dragand_drop_match.*
 import kotlinx.android.synthetic.main.common_toolbar.view.*
 import java.util.*
 import kotlin.collections.ArrayList

class DragandDropMatch : KotlinBaseActivity(), Listener, DragDropCheckListner {
    var textToSpeech: TextToSpeech? = null




    var commonRepository:CommonRepository?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragand_drop_match)
        commonRepository= CommonRepository(KidsApplication.myApp!!)

        settoolbar()
        initTextToSpeach()
     //   callapi()
        val topList: MutableList<ModelClass> = ArrayList()
        topList.add(ModelClass("Apple"))
        topList.add(ModelClass("Ball"))
        topList.add(ModelClass("Cat"))
        topList.add(ModelClass("Elephant"))
        intializeRecycle(topList = topList)
    }
    private  fun callapi()
    {
        val topList: MutableList<ModelClass> = ArrayList()
        commonRepository?.dragmatch(this,"dragmatch")
        {
            CorrectAns=it.data.correct_ans
            Picasso.get().load(it.data.image).placeholder(R.drawable.progress_animation).into(ivmatch)
            it.data.selectanswer.forEach {
                topList.add(ModelClass(it.ans))
            }
            intializeRecycle(topList = topList)
        }
    }
    companion object{
        var CorrectAns=""
    }
    private fun intializeRecycle(topList: MutableList<ModelClass> = ArrayList())
    {
//        rvTop!!.layoutManager = LinearLayoutManager(
//            this, LinearLayoutManager.HORIZONTAL, false
//        )
        val topListAdapter = DragDropAdapter(topList, this,this,this)

        rvTop!!.adapter = topListAdapter

    }
    private fun initTextToSpeach() {
        //text to speak
        textToSpeech = TextToSpeech(applicationContext, object : TextToSpeech.OnInitListener {
            override fun onInit(status: Int) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech
                    textToSpeech?.setLanguage(Locale.UK);
                }
            }

        })
    }
    private fun settoolbar() {
        toolbar.tvtitle.setText("Drag and Drop")
        toolbar.icmenu2.gone()
        toolbar.ivback.visible()
        toolbar.ivback.setImageResource(R.drawable.ic_baseline_arrow_back_24)
        toolbar.ivback.setOnClickListener {
            Keys.isSubmit = false
            onBackPressed()

        }
    }

    override fun isMatch(isture: Boolean) {
        if (isture)
        {
            speakerlotties.visibility= View.VISIBLE
            speakerlotties.playAnimation()
            speakerlotties.playSoundEffect(SoundEffectConstants.CLICK)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                textToSpeech?.speak("Congratulations ", TextToSpeech.SUCCESS, null, null)


            } else {
                textToSpeech?.speak("Congratulations", TextToSpeech.SUCCESS, null)
            }
            speakerlotties.addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator?) {
                    Log.e("animatioansattrt","1")
                }

                override fun onAnimationEnd(animation: Animator?) {
                    Log.e("animatioanend","1")
                    speakerlotties.visibility= View.GONE
                    speakerlotties.cancelAnimation()

                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationRepeat(animation: Animator?) {
                }
            })
        }
        else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                textToSpeech?.speak("Wrong ", TextToSpeech.SUCCESS, null, null)


            } else {
                textToSpeech?.speak("Wrong", TextToSpeech.SUCCESS, null)
            }
        }
     }

    override fun isclick(isture: Boolean) {
     }

    override fun setEmptyListTop(visibility: Boolean) {
     }

    override fun setEmptyListBottom(visibility: Boolean) {
     }

    override fun setpostion(position: Boolean) {
     }
}