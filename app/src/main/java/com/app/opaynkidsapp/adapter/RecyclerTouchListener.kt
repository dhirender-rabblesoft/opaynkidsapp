package com.app.opaynkidsapp.adapter

import android.content.Context
import android.util.Log
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener


class RecyclerTouchListener(
    context: Context?,
    recyclerView: RecyclerView,
    private val clickListener: ClickListener?
) :
    OnItemTouchListener {
    private val gestureDetector: GestureDetector = GestureDetector(context, object : SimpleOnGestureListener() {
        override fun onSingleTapUp(e: MotionEvent): Boolean {

            return true
        }

        override fun onLongPress(e: MotionEvent) {
            val child: View? = recyclerView.findChildViewUnder(e.x, e.y)
            if (child != null && clickListener != null) {
                clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child))
            }
        }
    })

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val child: View? = rv.findChildViewUnder(e.x, e.y)
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildAdapterPosition(child))
            Log.e("85dfdfdfdf","85888888")
        }
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        val child: View? = rv.findChildViewUnder(e.x, e.y)
        if (child != null && clickListener != null) {
            clickListener.onTouchEvent(child, rv.getChildAdapterPosition(child))
        }
    }
    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
    interface ClickListener {
        fun onClick(view: View?, position: Int)
        fun onLongClick(view: View?, position: Int)
        fun onTouchEvent(view: View?, position: Int)
    }

}
