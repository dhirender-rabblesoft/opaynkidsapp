package com.app.opaynkidsapp


import com.app.opaynkidsapp.base.BaseAdapter
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.model.Fillupjson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_guessword.view.*


class GuessWordAdapter(val baseActivity: KotlinBaseActivity, val itemClick: (Int) -> Unit) :
    BaseAdapter<Fillupjson.Data>(
        R.layout.item_guessword
    ) {
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
        Picasso.get().load(list[position].image).into(ivQuesImg)
            tvtitle.text=list[position].name
            llmain.setOnClickListener {
                itemClick(position)
            }


        }


    }
}