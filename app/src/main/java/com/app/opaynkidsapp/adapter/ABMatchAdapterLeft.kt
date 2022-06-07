package com.app.opaynkidsapp.adapter


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.model.LeftMatchListingModel
import com.app.opaynkidsapp.utils.Keys


class ABMatchAdapterLeft(
    var list: List<LeftMatchListingModel>,
    val context: Context,
    val itemClick: (Int) -> Unit

) :
    RecyclerView.Adapter<ABMatchAdapterLeft.ListViewHolder>()   {
    var ischeck = false
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(
            parent.context
        ).inflate(R.layout.item_match_a, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.text!!.text = list[position].name.toString()
        holder.frameLayout!!.tag = position
//        if (Keys.isSubmit){
//            if (list[position].selectedID.equals(list[position].answerID))
//            {
//
//                holder.frameLayout?.background = context.getDrawable( R.drawable.rectangle_shape_light_green)
//            } else{
//                holder.frameLayout?.background = context.getDrawable( R.drawable.rectangle_shape_light_red)
//            }
//        }


    }

    override fun getItemCount(): Int {
        return list.size
    }



    fun updateList(list: List<LeftMatchListingModel>) {
        this.list = list
    }



    inner class ListViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        var text: TextView? = itemView?.findViewById(R.id.tvButtontext)


        var frameLayout: ConstraintLayout? = itemView?.findViewById(R.id.llcontainer)
        var llcontainer: ConstraintLayout? = itemView?.findViewById(R.id.llcontainer)

    }


}