package com.app.opaynkidsapp.base


import android.content.Context
import android.view.DragEvent
import android.view.View
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.listner.Listener

class DragListener internal constructor(listener: Listener, val context: Context) :
    View.OnDragListener {
    private var isDropped = false
    private val listener: Listener = listener
    var targetid = -1
    override fun onDrag(v: View, event: DragEvent): Boolean {
        when (event.action) {
            DragEvent.ACTION_DROP -> {
                isDropped = true
                var positionTarget = -1
                val viewSource: View = event.localState as View
                val viewId: Int = v.getId()
                val flItem: Int = R.id.frame_layout_item
                val rvTop: Int = R.id.rvAmatcher
                val rvBottom: Int = R.id.rvBMatcher
                val cryanimation: Int = R.id.crylottiesanim
//
//                when (viewId) {
//                    flItem, rvTop, rvBottom,cryanimation -> {
//                        var target: RecyclerView
//
//                        when (viewId) {
//                            rvTop -> target = v.getRootView().findViewById(rvTop)
//
//                            else -> {
//                                target = v.getParent() as RecyclerView
//                                targetid = target.id
//                                positionTarget = v.getTag() as Int
//                            }
//                        }
//                        if (viewSource != null) {
//                            val source = viewSource.getParent() as RecyclerView
//                            val adapterSource: ABMatchAdapter? = source.adapter as ABMatchAdapter?
//                            val positionSource = viewSource.getTag() as Int
//                            val sourceId = source.id
//
//                            Log.e("positionSource",sourceId.toString())
//
////                            val list: RightMatchListingModel = adapterSource?.list?.get(positionSource)!!
//                            val listSource: ArrayList<RightMatchListingModel> =
//                                adapterSource.list as ArrayList<RightMatchListingModel>
//
//                            adapterSource.notifyDataSetChanged() //notifiy left adapter that item is selected or not and then change color
//                            if (sourceId == targetid){
//
//
//                                return false
//                            }
//
//                            val adapterTarget: ABMatchAdapter2? = target.adapter as ABMatchAdapter2?
//                            val customListTarget: MutableList<RightMatchListingModel> =
//                                adapterTarget?.list as MutableList<RightMatchListingModel>
//                            if (positionTarget >= 0) {
//
//                            } else {
//                                customListTarget.add(list)
//                            }
//                            adapterTarget.updateList(customListTarget)
//                            adapterTarget.notifyDataSetChanged()
//
//                            if (sourceId == rvBottom && adapterSource.getItemCount() < 1) {
//                                listener.setEmptyListBottom(true)
//                            }
//
//                        }
//                    }
//                }
            }
        }
        if (!isDropped && event.localState != null) {
            (event.localState as View).setVisibility(View.VISIBLE)
        }
        return true
    }

}