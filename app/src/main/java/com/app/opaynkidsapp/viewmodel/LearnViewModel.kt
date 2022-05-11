package com.app.opaynkidsapp.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityLearnBinding
import com.app.opaynkidsapp.extensions.gone
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.utils.Keys


class LearnViewModel(application: Application) : AppViewModel(application) {
    private lateinit var binder: ActivityLearnBinding
    private lateinit var mContext: Context
    lateinit var baseActivity: KotlinBaseActivity
    var isFlag = false
    var mediaPlayer: MediaPlayer? = null
    var isplaying = true
    var getBundle = Bundle()
    var mp: MediaPlayer = MediaPlayer()
    var listofword = ArrayList<String>()
    var listofAplhabet = ArrayList<String>()
    var listofNumber = ArrayList<String>()
    var i = 0
    fun setBinder(binder: ActivityLearnBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this
        getBundle = (baseActivity as Activity).intent.extras!!
        setStaticdata()
        setdata()
        setclicks()
        setAnimation()

    }

    private fun setAnimation() {
        val animationBounce = AnimationUtils.loadAnimation(baseActivity, R.anim.bounce)
        val animationfadeout = AnimationUtils.loadAnimation(baseActivity, R.anim.fade_in)
        binder.learnImg.startAnimation(animationBounce)
        binder.word.startAnimation(animationfadeout)
    }
    private fun setdata() {
        when (getBundle.get(Keys.FROM.toString())) {
            baseActivity.getString(R.string.alphabet) -> {

                binder.shapeview.gone()
                binder.learnImg.visible()
                listofword.clear()
                listofword = listofAplhabet
                binder.word.setText("A")
                settoolbar(baseActivity.getString(R.string.alphabet))
                binder.learnImg.setImageResource(R.drawable.apple)
                setmedia(R.raw.aaudio)


            }
            baseActivity.getString(R.string.numbers) -> {
                binder.learnImg.gone()
                binder.shapeview.gone()
                binder.learnImg.gone()
                binder.word.setText("1")
                listofword.clear()
                binder.learnTitle.setText("One")
                listofword = listofNumber
                settoolbar(baseActivity.getString(R.string.numbers))
                binder.learnImg.setImageResource(R.drawable.apple)

            }

            baseActivity.getString(R.string.colors) -> {
                settoolbar(baseActivity.getString(R.string.colors))


            }
            baseActivity.getString(R.string.shapes) -> {
                settoolbar(baseActivity.getString(R.string.shapes))
                binder.shapeview.visible()
                binder.learnImg.gone()
                binder.shapeview.setImageResource(R.drawable.cube)
                binder.learnTitle.setText("Cude")
                setmedia(R.raw.aaudio)

            }
            baseActivity.getString(R.string.animals) -> {
                settoolbar(baseActivity.getString(R.string.animals))


            }
            baseActivity.getString(R.string.objects) -> {
                settoolbar(baseActivity.getString(R.string.objects))

            }

        }

    }

    private fun setStaticdata(){
        listofAplhabet.add("A")
        listofAplhabet.add("B")
        listofAplhabet.add("C")
        listofAplhabet.add("D")
        listofAplhabet.add("E")
        listofAplhabet.add("F")
        listofAplhabet.add("G")
        listofAplhabet.add("H")
        listofAplhabet.add("I")

        //number
        listofNumber.add("1")
        listofNumber.add("2")
        listofNumber.add("3")
        listofNumber.add("4")
        listofNumber.add("5")
        listofNumber.add("6")
        listofNumber.add("7")
        listofNumber.add("8")
        listofNumber.add("9")
        listofNumber.add("10")




    }

    private fun setclicks() {


        binder.speakerlotties.setOnClickListener {
            mp.start()
            setAnimation()
            binder.speakerlotties.playAnimation()
        }

        binder.toolbar.icmenu2.setOnClickListener {
            baseActivity.onBackPressed()
        }
        binder.loginbutton.setOnClickListener {

            i++
            if (listofword.size >i ){
                binder.word.setText(listofword[i])    // body of loop
                setAnimation()
            }


        }
        binder.resetImg.setOnClickListener {
            setAnimation()
        }
        binder.priviousImg.setOnClickListener {
            if (i>0){
                --i
                binder.word.setText(listofword[i])    // body of loop
                setAnimation()

            }

        }

    }

    private fun setmedia(mediafile: Int) {
        mp = MediaPlayer.create(baseActivity, mediafile)

    }


    private fun settoolbar(title: String) {
        binder.toolbar.tvtitle.setText(title)
        binder.toolbar.icmenu2.visible()
        binder.toolbar.icmenu2.setImageResource(R.drawable.ic_baseline_arrow_back_24)
    }


}