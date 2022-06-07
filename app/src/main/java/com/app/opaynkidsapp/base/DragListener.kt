package com.app.opaynkidsapp.base


import android.content.Context
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.ABMatchAdapter
import com.app.opaynkidsapp.adapter.ABMatchAdapter2
import com.app.opaynkidsapp.listner.Listener
import com.app.opaynkidsapp.viewmodel.MatchListingModel

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

                when (viewId) {
                    flItem, rvTop, rvBottom,cryanimation -> {
                        var target: RecyclerView

                        when (viewId) {
                            rvTop -> target = v.getRootView().findViewById(rvTop)

                            else -> {
                                target = v.getParent() as RecyclerView
                                targetid = target.id
                                positionTarget = v.getTag() as Int
                            }
                        }
                        if (viewSource != null) {
                            val source = viewSource.getParent() as RecyclerView
                            val adapterSource: ABMatchAdapter? = source.adapter as ABMatchAdapter?
                            val positionSource = viewSource.getTag() as Int
                            val sourceId = source.id

                            Log.e("positionSource",sourceId.toString())

                            val list: MatchListingModel = adapterSource?.list?.get(positionSource)!!
                            val listSource: ArrayList<MatchListingModel> =
                                adapterSource.list as ArrayList<MatchListingModel>
                            listSource[positionSource].isdrag = false
                            adapterSource.notifyDataSetChanged() //notifiy left adapter that item is selected or not and then change color

                            if (sourceId == targetid || targetid == -1){
                                listSource[positionSource].isdrag = true

                                return false
                            }



                            val adapterTarget: ABMatchAdapter2? = target.adapter as ABMatchAdapter2?
                            val customListTarget: MutableList<MatchListingModel> =
                                adapterTarget?.list as MutableList<MatchListingModel>
                            if (positionTarget >= 0) {
                                when (list.name) {
                                    "A" -> {
                                        if (positionTarget.equals(0)) {
                                            val toast = Toast.makeText(context,"Right Match",Toast.LENGTH_LONG)
                                            toast.show()
                                            listSource[positionSource].isdrag = false
                                            listSource[positionSource].isclick = true
                                            listSource[positionSource].ans = 1
                                            customListTarget[positionTarget].isclick = true
                                            customListTarget[positionTarget].isenable = false

                                        } else {
                                            listSource[positionSource].isdrag = false
                                            customListTarget[positionTarget].isenable = false
                                            listSource[positionSource].ans = 0
                                            adapterSource.updateList(listSource)
                                            val toast = Toast.makeText(context,"Wrong Match",Toast.LENGTH_LONG)
                                            toast.show()
                                        }

                                    }
                                    "B" -> {
                                        if (positionTarget.equals(1)) {
                                            val toast = Toast.makeText(context,"Right Match",Toast.LENGTH_LONG)
                                            toast.show()
                                            listSource[positionSource].isdrag = false
                                            listSource[positionSource].isclick = true
                                            customListTarget[positionTarget].isenable = false
                                            listSource[positionSource].ans = 1
                                            customListTarget[positionTarget].isclick = true

                                        } else {
                                            listSource[positionSource].isdrag = false
                                            customListTarget[positionTarget].isenable = false
                                            listSource[positionSource].ans = 0
                                            adapterSource.updateList(listSource)
                                            val toast = Toast.makeText(context,"Wrong Match",Toast.LENGTH_LONG)
                                            toast.show()

                                        }

                                    }

                                    "C" -> {
                                        if (positionTarget.equals(2)) {
                                            val toast = Toast.makeText(context,"Right Match",Toast.LENGTH_LONG)
                                            toast.show()
                                            listSource[positionSource].isdrag = false
                                            listSource[positionSource].isclick = true
                                            customListTarget[positionTarget].isenable = false
                                            listSource[positionSource].ans = 1
                                            customListTarget[positionTarget].isclick = true

                                        } else {
                                            listSource[positionSource].isdrag = false
                                            customListTarget[positionTarget].isenable = false
                                            listSource[positionSource].ans = 0
                                            adapterSource.updateList(listSource)
                                            val toast = Toast.makeText(context,"Wrong Match",Toast.LENGTH_LONG)
                                            toast.show()

                                        }

                                    }
                                    "D" -> {
                                        if (positionTarget.equals(3)) {
                                            val toast = Toast.makeText(context,"Right Match",Toast.LENGTH_LONG)
                                            toast.show()
                                            listSource[positionSource].isdrag = false
                                            listSource[positionSource].isclick = true
                                            customListTarget[positionTarget].isenable = false
                                            listSource[positionSource].ans = 1
                                            customListTarget[positionTarget].isclick = true

                                        } else {
                                            listSource[positionSource].isdrag = false
                                            customListTarget[positionTarget].isenable = false
                                            listSource[positionSource].ans = 0
                                            adapterSource.updateList(listSource)
                                            val toast = Toast.makeText(context,"Wrong Match",Toast.LENGTH_LONG)
                                            toast.show()

                                        }
                                    }
                                }
                            } else {
                                customListTarget.add(list)
                            }
                            adapterTarget.updateList(customListTarget)
                            adapterTarget.notifyDataSetChanged()

                            if (sourceId == rvBottom && adapterSource.getItemCount() < 1) {
                                listener.setEmptyListBottom(true)
                            }

                        }
                    }
                }
            }
        }
        if (!isDropped && event.localState != null) {
            (event.localState as View).setVisibility(View.VISIBLE)
        }
        return true
    }

}