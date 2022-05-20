package com.app.opaynkidsapp.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorFilter
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.CanvasDraw
import com.app.opaynkidsapp.base.ColorPicker
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.extensions.visible
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.github.dhaval2404.colorpicker.model.ColorSwatch
import kotlinx.android.synthetic.main.activity_draw_practice.*
import kotlinx.android.synthetic.main.activity_otpverify.*
import kotlinx.android.synthetic.main.common_toolbar.view.*
import java.util.*

class DrawPractice : KotlinBaseActivity() {

    var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_practice)

        setClick()
        initTextToSpeach()
        val canvasView = CanvasDraw(this)
        canvasView.width = 50
        canvasView.height = 50
        parentView.addView(canvasView)


        drawWord.visible()

        selectcolor.setOnClickListener {
            val colorDailog = ColorPicker(this) {
                selectcolor.setBackgroundColor(resources.getColor(it))
                canvasView.setcolor(resources.getColor(it))
            }
            colorDailog.show(supportFragmentManager, colorDailog.tag)
        }

//        selectcolor.setOnClickListener {
//            setCommonButtonClickEffect(it)
//            MaterialColorPickerDialog
//                .Builder(this)                            // Pass Activity Instance
//                .setTitle("Pick Theme")                // Default "Choose Color"
//                .setColorShape(ColorShape.SQAURE)    // Default ColorShape.CIRCLE
//                .setColorSwatch(ColorSwatch._300)    // Default ColorSwatch._500
//                .setDefaultColor(R.color.black)        // Pass Default Color
//                .setColorListener { color, colorHex ->
//                    // Handle Color Selection
//                    selectcolor.setBackgroundColor(color)
//
//                    canvasView.setcolor(color)
//                }
//                .show()
//        }


        cleanCanvas.setOnClickListener {
            setCommonButtonClickEffect(it)
            canvasView.clearCanvas()
        }


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


    // animation base on x and y axis screen and move according to given x and y values
//    private fun setanimation() {
//
//        drawWord.animate().translationXBy(300f).translationY(50f).duration = 1000
//    }


    private fun setClick() {
        backbutton.setOnClickListener {
            onBackPressed()
        }
        drawspeaker.setOnClickListener {
            setCommonButtonClickEffect(it)
//            speakerlotties.playAnimation()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                textToSpeech?.speak("A", TextToSpeech.QUEUE_FLUSH, null, null)

            } else {
                textToSpeech?.speak("A", TextToSpeech.QUEUE_FLUSH, null)
            }

        }
    }


}