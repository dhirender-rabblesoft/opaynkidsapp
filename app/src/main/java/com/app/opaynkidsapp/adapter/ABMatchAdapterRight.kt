package com.app.opaynkidsapp.adapter



import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.utils.Keys
import com.app.opaynkidsapp.viewmodel.RightMatchListingModel


class ABMatchAdapterRight(
    var list: List<RightMatchListingModel>,

    val context: Context
) :
    RecyclerView.Adapter<ABMatchAdapterRight.ListViewHolder>(), View.OnTouchListener {
    var ischeck = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(
            parent.context
        ).inflate(R.layout.item_match, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

//        holder.text!!.text = list[position].name.toString()
        holder.objectImage?.setImageResource(list[position].img_url)
        holder.frameLayout!!.tag = position
        if (Keys.isSubmit ) {
            if (list[position].isRight){
                holder.frameLayout!!.setBackgroundColor(Color.GREEN)
            }else{
                holder.frameLayout!!.setBackgroundColor(Color.RED)
            }
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {

        //drag and drop from left to right
//        when (event.action) {
//            MotionEvent.ACTION_DOWN -> {
//                val data = ClipData.newPlainText("", "")
//                val shadowBuilder = View.DragShadowBuilder(v)
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                    v.startDragAndDrop(data, shadowBuilder, v, 0)
//                } else {
//                    v.startDrag(data, shadowBuilder, v, 0)
//                }
//                return true
//            }
//        }
        return false
    }

    fun updateList(list: List<RightMatchListingModel>) {
        this.list = list
    }


    inner class ListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

//        var text: TextView? = itemView?.findViewById(R.id.tvButtontext)
        var objectImage: AppCompatImageView? = itemView?.findViewById(R.id.tvButtontext)
        var llcontainer: ConstraintLayout? = itemView?.findViewById(R.id.llcontainer)


        var frameLayout: ConstraintLayout? = itemView?.findViewById(R.id.frame_layout_item)

    }

}