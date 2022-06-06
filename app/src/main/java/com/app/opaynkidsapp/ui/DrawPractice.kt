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
import com.app.opaynkidsapp.extensions.gone
import com.app.opaynkidsapp.extensions.setLeftMargin
import com.app.opaynkidsapp.extensions.setTopMargin
import com.app.opaynkidsapp.extensions.visible
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.github.dhaval2404.colorpicker.model.ColorSwatch
import kotlinx.android.synthetic.main.activity_draw_practice.*
import kotlinx.android.synthetic.main.activity_otpverify.*
import kotlinx.android.synthetic.main.common_toolbar.view.*
import java.util.*

class DrawPractice : AppCompatActivity() {

    var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_practice)
        setToolbar()
        setClick()
        initTextToSpeach()

        val canvasView = CanvasDraw(this)
        canvasView.width = 50
        canvasView.height = 50
        parentView.addView(canvasView)

        setanimation()
        drawWord.visible()


        selectcolor.setOnClickListener {
            MaterialColorPickerDialog
                .Builder(this)                            // Pass Activity Instance
                .setTitle("Pick Theme")                // Default "Choose Color"
                .setColorShape(ColorShape.SQAURE)    // Default ColorShape.CIRCLE
                .setColorSwatch(ColorSwatch._300)    // Default ColorSwatch._500
                .setDefaultColor(R.color.black)        // Pass Default Color
                .setColorListener { color, colorHex ->
                    // Handle Color Selection
                    selectcolor.setBackgroundColor(color)

                    canvasView.setcolor(color)
                }
                .show()
        }


        cleanCanvas.setOnClickListener {
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



    private fun setanimation() {

        drawWord.animate().translationXBy(400f).translationY(100f).duration = 1000
    }

    private fun setToolbar() {
        toolbar.tvtitle.setText("Draw Practice")
        toolbar.ivback.visible()
        toolbar.icmenu2.gone()
         toolbar.ivback.setImageResource(R.drawable.ic_baseline_arrow_back_24)
    }

    private fun setClick() {
        toolbar.ivback.setOnClickListener {
            onBackPressed()
        }

        speakerlotties.setOnClickListener {
//            speakerlotties.playAnimation()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                textToSpeech?.speak("A", TextToSpeech.QUEUE_FLUSH, null, null)

            } else {
                textToSpeech?.speak("A", TextToSpeech.QUEUE_FLUSH, null)
            }

        }
    }


}