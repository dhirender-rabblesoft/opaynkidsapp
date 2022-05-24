package com.app.opaynkidsapp.adapter

import android.util.Log
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.BaseAdapter
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.utils.Keys
import kotlinx.android.synthetic.main.item_match_a.view.*


class AmatchAdapter(val baseActivity: KotlinBaseActivity, val itemClick: (Int) -> Unit) :
    BaseAdapter<String>(R.layout.item_match_a) {

    var isSelect = false
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
//            tvButtontext.setText(list[position])

            mainlayout.setOnClickListener {
                itemClick(position)
                val originalPos = IntArray(2)
                it.getLocationOnScreen(originalPos)
                val x = originalPos[0]
                val y = originalPos[1]
                Keys.startx = x.toFloat()
                Keys.starty = y.toFloat()
                Log.e("1551515151","$x  dkdkdfkkdf $y")

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