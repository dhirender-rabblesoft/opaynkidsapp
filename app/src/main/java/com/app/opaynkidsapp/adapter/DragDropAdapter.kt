package com.app.opaynkidsapp.adapter


import android.content.ClipData
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.*
import android.view.DragEvent.ACTION_DRAG_ENDED
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.DragListener
import com.app.opaynkidsapp.listner.DragDropCheckListner
import com.app.opaynkidsapp.listner.DragDropListener
import com.app.opaynkidsapp.listner.Listener
import com.app.opaynkidsapp.model.ModelClass


internal class DragDropAdapter(
    var list: List<ModelClass>,
    private val listener: Listener?,
    private val checkListner: DragDropCheckListner?,
    val context: Context
) :
    RecyclerView.Adapter<DragDropAdapter.ListViewHolder>(), View.OnTouchListener, DragDropCheckListner {
    var ischeck = false
    var pos = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(
            parent.context
        ).inflate(R.layout.item_drag_drap, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.text!!.text = list[position].name.toString()
        holder.frameLayout!!.tag = position


        Log.e("fistruncode", list.toString())


        holder.frameLayout!!.setOnTouchListener(this)
        holder.frameLayout!!.setOnDragListener(DragDropListener(listener!!, checkListner!!, context))


//        if (list[position].isdrag){
//
//        }


        if (list[position].isclick) {
            holder.frameLayout!!.setBackgroundColor(Color.GREEN)

        } else {

            Handler(Looper.getMainLooper()).postDelayed({
                if (!list[position].isdrag){
                    holder.frameLayout!!.setBackgroundColor(Color.GRAY)
                }else{
                    holder.frameLayout!!.setBackgroundColor(context.resources.getColor(R.color.main_color))
                }

            }, 500)
          //  holder.frameLayout!!.setBackgroundColor(context.resources.getColor(R.color.red))

        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {


        val tag = v.tag
        if (list[tag as Int].isdrag) {

            pos = tag
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    checkListner?.isclick(true)
                    Log.e("hehehhehehehe",pos.toString())
                    val data = ClipData.newPlainText("", "")
                    val shadowBuilder = View.DragShadowBuilder(v)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        v.startDragAndDrop(data, shadowBuilder, v, 0)
                    } else {
                        v.startDrag(data, shadowBuilder, v, 0)
                    }
                    return true
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    Log.e("ACTION_DRAG_ENDED",pos.toString())
                    return true
                }



            }
        }


        return false
    }

    fun updateList(list: List<ModelClass>) {
        this.list = list
    }

    val dragInstance: DragDropListener?
        get() = if (listener != null) {

            DragDropListener(listener, checkListner!!, context)
        } else {

            null
        }

    internal inner class ListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        var text: TextView? = itemView?.findViewById(R.id.text)
        var frameLayout: ConstraintLayout? = itemView?.findViewById(R.id.frame_layout_item)
    }

    override fun isMatch(isture: Boolean) {
        ischeck = isture
    }

    override fun isclick(isture: Boolean) {

    }
}