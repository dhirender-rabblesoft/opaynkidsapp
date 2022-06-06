package com.app.opaynkidsapp.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.app.opaynkidsapp.R

import com.app.opaynkidsapp.base.BaseAdapter
import com.app.opaynkidsapp.base.KotlinBaseActivity
import com.app.opaynkidsapp.model.LevelModel
import com.app.opaynkidsapp.model.ObjectsJson
import com.app.opaynkidsapp.ui.HomeScreen
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_select_topic.view.*


class ObjectAdapter (val baseActivity: KotlinBaseActivity, val itemClick:(Int) -> Unit) : BaseAdapter<ObjectsJson.Data>(
    R.layout.item_select_topic)
{
    override fun onBindViewHolder(holder: IViewHolder, position: Int) {
        holder.itemView.apply {
           // topicimg.setImageResource(list[position].img)
            Picasso.get().load(list[position].image).into(topicimg)
            tvtopictitle.setText(list[position].data)

            mainlayout.setOnClickListener {
                itemClick(position)
            }

//            if (HomeScreen.packagecolorlist.size > 0) {
//                val layout: View = mainlayout
//
//                val gd = GradientDrawable(
//                    GradientDrawable.Orientation.BL_TR, intArrayOf(
//                        Color.parseColor(HomeScreen.packagecolorlist[position % HomeScreen.packagecolorlist.count()]),
//                        Color.parseColor(HomeScreen.packagesubcolorlist[position % HomeScreen.packagesubcolorlist.count()])
//                    )
//                )
//                layout.background = gd
////                tvtopictitle.setTextColor(Color.parseColor(HomeScreen.packagecolorlist[position % HomeScreen.packagecolorlist.count()]))
////                tvleveldetail.setTextColor(Color.parseColor(HomeScreen.packagecolorlist[position % HomeScreen.packagecolorlist.count()]))
//                tvtopictitle.setTextColor(Color.WHITE)
//
//
//            }
        }


    }






}