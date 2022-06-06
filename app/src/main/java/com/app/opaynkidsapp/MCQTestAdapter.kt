package com.app.opaynkidsapp

import androidx.core.content.ContextCompat
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.BaseAdapter
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.model.ModelClass
import kotlinx.android.synthetic.main.item_mcq_button.view.*


class MCQTestAdapter(val baseActivity: KotlinBaseActivity, val itemClick: (Int) -> Unit) :
    BaseAdapter<String>(R.layout.item_mcq_button) {

    var isSelect = false
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {

            tvButtontext.setText(list[position])
//            if ( list[position].isclick)
//            {
//                mainlayout.setBackgroundColor(ContextCompat.getColor(context,R.color.main_color))
//            }

            mainlayout.setOnClickListener {

//                if (!list[position].isclick)
//                {
//                    itemClick(position)
//                    list[position].isclick=true
//                    notifyDataSetChanged()
//
//                }

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