package com.app.opaynkidsapp.adapter



import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.extensions.isNotNull
import com.app.opaynkidsapp.model.RightMatchListingModel
import com.app.opaynkidsapp.utils.Keys
import com.squareup.picasso.Picasso


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
        Picasso.get().load(list[position].img_url).into(holder.objectImage)
         Log.e("imageurllll",list[position].img_url)
         Log.e("imagesssid",list[position].id.toString())
         holder.frameLayout!!.tag = position
        if (Keys.isSubmit ) {
            if (list[position].isRight){
                holder.frameLayout?.background = context.getDrawable( R.drawable.rectangle_shape_light_green)
            }else{
                holder.frameLayout?.background = context.getDrawable( R.drawable.rectangle_shape_light_red)
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