package com.app.opaynkidsapp.adapter

import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.BaseAdapter
import com.app.opaynkidsapp.base.KotlinBaseActivity
import kotlinx.android.synthetic.main.item_mcq_button.view.*


class MCQButtonAdapter(val baseActivity: KotlinBaseActivity, val itemClick: (Int) -> Unit) :
    BaseAdapter<Char>(R.layout.item_mcq_button) {

    var isSelect = false
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {

            tvButtontext.setText(list[position].toString())

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





}