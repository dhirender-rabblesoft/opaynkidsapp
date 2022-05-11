package com.app.opaynkidsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.CanvasDraw
import com.app.opaynkidsapp.extensions.visible
import kotlinx.android.synthetic.main.activity_draw_practice.*
import kotlinx.android.synthetic.main.common_toolbar.view.*

class DrawPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_practice)
        setToolbar()
        setClick()
        val canvasView = CanvasDraw(this)
        canvasView.width = 50
        canvasView.height = 50
        parentView.addView(canvasView)
        button.setOnClickListener {
            canvasView.clearCanvas()
        }
    }

    private fun setToolbar() {
        toolbar.tvtitle.setText("Draw Practice")
        toolbar.icmenu2.visible()
        toolbar.icmenu2.setImageResource(R.drawable.ic_baseline_arrow_back_24)
    }

    private fun setClick() {
        toolbar.icmenu2.setOnClickListener {
            onBackPressed()
        }
    }
}