package com.app.opaynkidsapp.adapter


import android.util.Log
import android.view.ViewGroup
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.BaseAdapter
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.extensions.isNotNull
import kotlinx.android.synthetic.main.item_fill_blank_test.view.*


class FillBlankTestAdapter(
    val addlist: ArrayList<String>,
    val baseActivity: KotlinBaseActivity,
    val itemClick: (Int) -> Unit
) :
    BaseAdapter<Char>(R.layout.item_fill_blank_test) {
    val answer = "apple"


    var isSelect = false

    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {

            tvshowword.setText(addlist[position].toString())
//            if (addlist.size > 0) {
//                if (position <addlist.size){
//                    ans2.set(position,addlist[position])
//
//                }
//
//            }


        }
    }

    override fun getItemCount(): Int {
        return answer.length
    }

}