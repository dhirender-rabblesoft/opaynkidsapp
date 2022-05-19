package com.app.opaynkidsapp.adapter


import android.content.ClipData
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.DragListener
 import com.app.opaynkidsapp.listner.Listener
import com.app.opaynkidsapp.utils.Keys
import com.app.opaynkidsapp.viewmodel.MatchListingModel


class ABMatchAdapter(
    var list: List<MatchListingModel>,
    val listener: Listener?,
    val context: Context,
    val itemClick: (Int) -> Unit

) :
    RecyclerView.Adapter<ABMatchAdapter.ListViewHolder>(), View.OnTouchListener  {
    var ischeck = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(
            parent.context
        ).inflate(R.layout.item_match, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        itemClick(position)
        holder.text!!.text = list[position].name.toString()
        holder.frameLayout!!.tag = position
        holder.frameLayout!!.setOnTouchListener(this)
        holder.frameLayout!!.setOnDragListener(DragListener(listener!!, context))

        if (list[position].isclick) {
            if (Keys.isSubmit) {
                if (list[position].isclick) {
                    holder.frameLayout!!.setBackgroundColor(Color.GREEN)
                }

            }
            holder.llcontainer!!.setBackgroundColor(context.resources.getColor(R.color.black_30))
//            itemClick(position)
        } else {

            if (Keys.isSubmit) {
                if (!list[position].isclick) {
                    holder.frameLayout!!.setBackgroundColor(Color.RED)
                }

            }
            if (list[position].ans.equals(0)) {
                itemClick(position)
            }

            Handler(Looper.getMainLooper()).postDelayed({
                if (!list[position].isdrag) {
                    holder.llcontainer!!.setBackgroundColor(context.resources.getColor(R.color.black_30))
                } else {
                    holder.frameLayout!!.setBackgroundColor(context.resources.getColor(R.color.main_color))
                }

            }, 500)

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        val tag = v.tag
        if (list[tag as Int].isdrag) {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    val data = ClipData.newPlainText("", "")
                    val shadowBuilder = View.DragShadowBuilder(v)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        v.startDragAndDrop(data, shadowBuilder, v, 0)

                    } else {
                        v.startDrag(data, shadowBuilder, v, 0)
                    }
                    return true
                }
            }
        }
        return false
    }

    fun updateList(list: List<MatchListingModel>) {
        this.list = list
    }

    val dragInstance: DragListener?
        get() = if (listener != null) {
            DragListener(listener, context)
        } else {
            Log.e("ListAdapter", "Listener wasn't initialized!")
            null
        }

    inner class ListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        var text: TextView? = itemView?.findViewById(R.id.tvButtontext)


        var frameLayout: ConstraintLayout? = itemView?.findViewById(R.id.frame_layout_item)
        var llcontainer: ConstraintLayout? = itemView?.findViewById(R.id.llcontainer)

    }


}