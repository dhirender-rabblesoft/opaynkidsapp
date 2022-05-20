package com.app.opaynkidsapp.adapter

import android.util.Log
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.BaseAdapter
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.extensions.gone
import com.app.opaynkidsapp.extensions.visible
import com.app.opaynkidsapp.viewmodel.ColorPickerModel
import kotlinx.android.synthetic.main.item_color_box.view.*

class ColorPickerAdapter(val baseActivity: KotlinBaseActivity, val itemclick: (Int) -> Unit) :
    BaseAdapter<ColorPickerModel>(
        R.layout.item_color_box
    ) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        Log.e("listodcolrswssss",list.toString())
        holder.itemView.apply {

            if (!list[position].previousvalue.equals(-1)){

            }

            if (list[position].isSelected) {

                selectedcolortick.visible()
            } else {
                selectedcolortick.gone()
            }

            colorbox.setBackgroundColor(baseActivity.resources.getColor(list[position].colorcode))
            colorbox.setOnClickListener {
                itemclick(position)
                for (item in list.indices) {
                    if (item == position) {
                        list[item].isSelected = true
                        list[position].previousvalue = position
                    } else {
                        list[item].isSelected = false
                    }
                }

                notifyDataSetChanged()
            }


        }
    }


}