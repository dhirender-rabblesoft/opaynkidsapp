package com.app.opaynkidsapp.adapter

import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.BaseAdapter
import com.app.opaynkidsapp.base.KotlinBaseActivity
import kotlinx.android.synthetic.main.item_match.view.*


class AmatchAdapter(val baseActivity: KotlinBaseActivity, val itemClick: (Int) -> Unit) :
    BaseAdapter<String>(R.layout.item_match) {

    var isSelect = false
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {

            tvButtontext.setText(list[position])

            mainlayout.setOnClickListener {
                itemClick(position)
                if (isSelected){
                    isSelect = false
                    mainlayout.setBackgroundColor(baseActivity.resources.getColor(R.color.white))
                }else {
                    isSelected = true
                    mainlayout.setBackgroundColor(baseActivity.resources.getColor(R.color.main_color))
                }
            }

        }


    }

    fun swapItems(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition..toPosition - 1) {
                list.set(i, list.set(i+1, list.get(i)));
            }
        } else {
            for (i in fromPosition..toPosition + 1) {
                list.set(i, list.set(i-1, list.get(i)));
            }
        }

        notifyItemMoved(fromPosition, toPosition)
    }


}