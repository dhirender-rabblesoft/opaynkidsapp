package com.app.opaynkidsapp.adapter


import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.base.BaseAdapter
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.extensions.isNotNull
import kotlinx.android.synthetic.main.item_fill_blank_test.view.*


class FillBlankTestAdapter(val baseActivity: KotlinBaseActivity, val itemClick: (Int) -> Unit) :
    BaseAdapter<String>(R.layout.item_fill_blank_test) {

    var isSelect = false
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
            tvshowword.setText(list[position])
        }

    }

}