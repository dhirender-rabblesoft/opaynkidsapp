package com.app.opaynkidsapp.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.animation.AnimationUtils
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.AppViewModel
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.databinding.ActivityLearnBinding
import com.app.opaynkidsapp.extensions.gone
import com.app.opaynkidsapp.extensions.isNotNull
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.model.NumberJson
import com.app.opaynkidsapp.repository.CommonRepository
import com.app.opaynkidsapp.utils.Keys
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList
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
    var commonRepository: CommonRepository = CommonRepository(application)
    var numberlist=ArrayList<NumberJson.Data>()
    var textToSpeech: TextToSpeech? = null

    fun setBinder(binder: ActivityLearnBinding, baseActivity: KotlinBaseActivity) {
        this.binder = binder
        this.mContext = binder.root.context
        this.baseActivity = baseActivity
        this.binder.viewModel = this
        getBundle = (baseActivity as Activity).intent.extras!!

        setdata()
        setclicks()
       // setAnimation()
        initTextToSpeach()

    }
    private fun initTextToSpeach() {
        //text to speak
        textToSpeech = TextToSpeech(baseActivity, object : TextToSpeech.OnInitListener {
            override fun onInit(status: Int) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech
                    textToSpeech?.setLanguage(Locale.UK);
                }
            }

        })
    }

    private fun setAnimation()
    {
        val animationBounce = AnimationUtils.loadAnimation(baseActivity, R.anim.bounce)
        val animationfadeout = AnimationUtils.loadAnimation(baseActivity, R.anim.fade_in)
        binder.learnImg.startAnimation(animationBounce)
        binder.word.startAnimation(animationfadeout)
    }
    private fun setdata()
    {
        when (getBundle.get(Keys.FROM.toString())) {
            baseActivity.getString(R.string.alphabet) -> {
                binder.shapeview.gone()
                binder.word.gone()
                binder.learnImg.visible()
                listofword.clear()
                listofword = listofAplhabet
                settoolbar(baseActivity.getString(R.string.alphabet))
              //  binder.learnImg.setImageResource(R.drawable.apple)
                setmedia(R.raw.aaudio)
                getnumberapi(Keys.GETALPHABET)
            }
            baseActivity.getString(R.string.numbers) -> {
                binder.learnImg.gone()
                binder.shapeview.gone()
                binder.learnImg.gone()
                settoolbar(baseActivity.getString(R.string.numbers))
                binder.learnImg.setImageResource(R.drawable.apple)
                getnumberapi(Keys.GETNUMBER)

            }

            baseActivity.getString(R.string.colors) -> {
                settoolbar(baseActivity.getString(R.string.colors))

                getnumberapi(Keys.GETCOLORS)
            }
            baseActivity.getString(R.string.shapes) -> {

                if (getBundle.get(Keys.FROM).toString().equals("Shapes"))
                {
                    settoolbar(baseActivity.getString(R.string.shapes))
                    getnumberapi(Keys.SHAPES)
                }

               else  if (getBundle.get(Keys.POSTID).toString().isNotNull()&& !getBundle.get(Keys.POSTID).toString().equals("null"))
                {
                    settoolbar(getBundle.get(Keys.POSTNAME).toString())
                    getnumberapi(Keys.CLASSDETAIL+getBundle.get(Keys.POSTID).toString())
                }
                else{

                    settoolbar(getBundle.get(Keys.POSTNAME).toString())
                    getnumberapi(Keys.CLASSDETAIL+getBundle.get(Keys.POSTID).toString())
//                    settoolbar(baseActivity.getString(R.string.shapes))
//                    getnumberapi(Keys.SHAPES)
                }
                setmedia(R.raw.aaudio)

                binder.shapeview.visible()
                binder.learnImg.gone()
              //  binder.shapeview.setImageResource(R.drawable.cube)
               // binder.learnTitle.setText("Cude")


            }

            baseActivity.getString(R.string.objects) -> {
                settoolbar(baseActivity.getString(R.string.objects))

            }
            else->{
                settoolbar(baseActivity.getString(R.string.objects))

                settoolbar(getBundle.get(Keys.POSTNAME).toString())
                getnumberapi(Keys.CLASSDETAIL+getBundle.get(Keys.POSTID).toString())
            }

        }
    }


    private  fun getnumberapi(url:String)
    {
        commonRepository.getnumbers(baseActivity,url = url){
             if (it.data.size>0)
             {
                 binder.commonButton.commonPreButton.gone()
                 numberlist.addAll(it.data)

                 if (baseActivity.getString(R.string.alphabet).equals(binder.toolbar.tvtitle.text))
                 {
                     binder.word.setText(numberlist[0].number)
                     Picasso.get().load(numberlist[0].image).into(binder.learnImg)
                     binder.learnTitle.setText(numberlist[0].number+" for "+numberlist[0].data)
                 }
                 else if (baseActivity.getString(R.string.shapes).equals(binder.toolbar.tvtitle.text))
                 {

                     Picasso.get().load(numberlist[0].image).into(binder.shapeview)
                     binder.learnTitle.setText(numberlist[0].data)
                 }
                 else if (baseActivity.getString(R.string.colors).equals(binder.toolbar.tvtitle.text))
                 {
                     binder.shapeview.visible()
                     Picasso.get().load(numberlist[0].image).into(binder.shapeview)
                     binder.learnTitle.setText(numberlist[0].data)
                 }
                 else{
                     if (getBundle.get(Keys.POSTID).toString().isNotNull()&&!getBundle.get(Keys.POSTID).toString().equals("null"))
                     {

                         Picasso.get().load(numberlist[0].image).into(binder.shapeview)
                         binder.learnTitle.setText(numberlist[0].data)
                     }
                     else{
                         binder.word.setText(numberlist[0].number)
                         binder.learnTitle.setText(numberlist[0].data)

                     }

                 }
                 setAnimation()
             }
        }
    }

    private fun setclicks() {


        binder.speakerlotties.setOnClickListener {
           // mp.start()
            setAnimation()
            binder.speakerlotties.playAnimation()
            textToSpeech?.speak(binder.learnTitle.text.toString(), TextToSpeech.SUCCESS, null, null)
        }

        binder.toolbar.ivback.setOnClickListener {
            baseActivity.onBackPressed()
        }
        binder.commonButton.commonNextButton.setOnClickListener {


            if (numberlist.size-1>i ){
                binder.commonButton.commonPreButton.visible()
                ++i
                if (numberlist.size-1==i)
                {
                    binder.commonButton.commonNextButton.gone()
                }
                if (baseActivity.getString(R.string.alphabet).equals(binder.toolbar.tvtitle.text))
                {
                    binder.word.setText(numberlist[i].number)
                    Picasso.get().load(numberlist[i].image).into(binder.learnImg)
                    binder.learnTitle.setText(numberlist[i].number+" for "+numberlist[i].data)    // body of loop
                }
                else if (baseActivity.getString(R.string.shapes).equals(binder.toolbar.tvtitle.text))
                {
                    Picasso.get().load(numberlist[i].image) .into(binder.shapeview)
                    binder.learnTitle.setText(numberlist[i].data)
                }
                else if (baseActivity.getString(R.string.colors).equals(binder.toolbar.tvtitle.text))
                {
                    Picasso.get().load(numberlist[i].image) .into(binder.shapeview)
                    binder.learnTitle.setText(numberlist[i].data)
                }
                else{
                    if (getBundle.get(Keys.POSTID).toString().isNotNull()&& !getBundle.get(Keys.POSTID).toString().equals("null"))
                    {
                        Picasso.get().load(numberlist[i].image) .into(binder.shapeview)
                        binder.learnTitle.setText(numberlist[i].data)
                    }
                    else{
                        binder.word.setText(numberlist[i].number)
                        binder.learnTitle.setText(numberlist[i].data)
                    }
                  // body of loop
                }

                // body of loop
                setAnimation()
            }


        }
        binder.resetImg.setOnClickListener {
            setAnimation()
        }
        binder.commonButton.commonPreButton.setOnClickListener {
            if (i>0){
                --i

                if (i<numberlist.size-1)
                {
                    binder.commonButton.commonNextButton.visible()
                }


                if (baseActivity.getString(R.string.alphabet).equals(binder.toolbar.tvtitle.text))
                {
                    binder.word.setText(numberlist[i].number)
                    Picasso.get().load(numberlist[i].image).into(binder.learnImg)
                    binder.learnTitle.setText(numberlist[i].number+" for "+numberlist[i].data)    // body of loop
                }
                else if (baseActivity.getString(R.string.shapes).equals(binder.toolbar.tvtitle.text)
                    ||baseActivity.getString(R.string.colors).equals(binder.toolbar.tvtitle.text))
                {
                    Picasso.get().load(numberlist[i].image) .into(binder.shapeview)
                    binder.learnTitle.setText(numberlist[i].data)
                }
                else{
                    if (getBundle.get(Keys.POSTID).toString().isNotNull()&& !getBundle.get(Keys.POSTID).toString().equals("null"))
                    {
                        Picasso.get().load(numberlist[i].image) .into(binder.shapeview)
                        binder.learnTitle.setText(numberlist[i].data)
                    }
                    else{
                        binder.word.setText(numberlist[i].number)
                        binder.learnTitle.setText(numberlist[i].data)
                    }
                    // body of loop
                }

                    // body of loop


            }

        }

    }

    private fun setmedia(mediafile: Int) {
        mp = MediaPlayer.create(baseActivity, mediafile)

    }


    private fun settoolbar(title: String) {
        binder.toolbar.tvtitle.setText(title)
        binder.toolbar.ivback.visible()
        binder.toolbar.icmenu2.gone()
        binder.toolbar.ivback.setImageResource(R.drawable.ic_baseline_arrow_back_24)
    }


}