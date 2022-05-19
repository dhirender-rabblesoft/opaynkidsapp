package com.app.opaynkidsapp.base

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import com.app.opaynkidsapp.listner.ItemClick


class KotlinCanvas(var mcontext: Context,val itemClick: ItemClick) : View(
    mcontext
) {
    var mwidth = 0
    var mheight = 0
    private var mBitmap: Bitmap? = null
    private var mCanvas: Canvas? = null
    private val mPath: Path
    private val mPaint: Paint
    private var mX = 0f
    private var mY = 0f
    var startx: Float? = null
    var starty: Float? = null

    // override onSizeChanged
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        // your Canvas will draw onto the defined Bitmap
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        mCanvas = Canvas(mBitmap!!)
    }

    // override onDraw
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // draw the mPath with the mPaint on the canvas when onDraw
        canvas.drawPath(mPath, mPaint)
    }

    // when ACTION_DOWN start touch according to the x,y values
    fun startTouch(x: Float, y: Float) {
//        checkItemClick.onItemViewClicked(x,y);
        mPath.moveTo(x, y)
        mX = x
        mY = y
    }

    // when ACTION_MOVE move touch according to the x,y values
    private fun moveTouch(x: Float, y: Float) {
        val dx = Math.abs(x - mX)
        val dy = Math.abs(y - mY)
        if (dx >= TOLERANCE || dy >= TOLERANCE) {
//            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
//            mPath.lineTo(x, y);
            mX = x
            mY = y
        }
    }

    fun clearCanvas() {
        mPath.reset()
        invalidate()
    }

    //    // when ACTION_UP stop touch
    //    private void upTouch() {
    //        mPath.lineTo(mX, mY);
    //
    //    }
    // when ACTION_UP stop touch
    fun upTouch(x: Float, y: Float) {
        mPath.lineTo(x, y)
    }

    fun addtargetline(x: Float, y: Float) {
//        checkItemClick.onItemViewClicked2(x,y);
        mX = x
        mY = y
        mPath.lineTo(x, y)
    }

    //override the onTouchEvent
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startx = x
                starty = y
                itemClick.onItemViewClicked(x,y)
                startTouch(x, y)
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                moveTouch(x, y)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                //                upTouch();
                itemClick.onItemViewClicked2(x,y)
                addtargetline(x, y)
                invalidate()
            }
        }
        return true
    }

    companion object {
        private const val TOLERANCE = 5f
    }

    init {
        // we set a new Path
        mPath = Path()

        // and we set a new Paint with the desired attributes
        mPaint = Paint()
        mPaint.isAntiAlias = true
        mPaint.color = Color.BLUE
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeJoin = Paint.Join.ROUND
        mPaint.strokeWidth = 10f
    }
}
