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
                when (viewId) {
                    flItem, rvTop, rvBottom -> {
                        var target: RecyclerView
                        when (viewId) {
                            rvTop -> target = v.getRootView().findViewById(rvTop)
                            rvBottom -> target =
                                v.getRootView().findViewById(rvBottom)
                            else -> {

                                target = v.getParent() as RecyclerView
                                positionTarget = v.getTag() as Int
                            }
                        }
                        if (viewSource != null) {
                            val source = viewSource.getParent() as RecyclerView
                            val adapterSource: ABMatchAdapter? = source.adapter as ABMatchAdapter?
                            val positionSource = viewSource.getTag() as Int
                            val sourceId = source.id

                            val list: MatchListingModel = adapterSource?.list?.get(positionSource)!!
                            val listSource: ArrayList<MatchListingModel> =
                                adapterSource.list as ArrayList<MatchListingModel>
                            listSource.removeAt(positionSource)
                            adapterSource.updateList(listSource)
                            Log.e("adaptersource-- ", adapterSource.toString())
                            adapterSource.notifyDataSetChanged()

                            val adapterTarget: ABMatchAdapter2? = target.adapter as ABMatchAdapter2?
                            val customListTarget: MutableList<MatchListingModel> =
                                adapterTarget?.list as MutableList<MatchListingModel>
                            if (positionTarget >= 0) {
                                when (list.name) {
                                    'A' -> {
                                        if (positionTarget.equals(0)) {
                                            val toast = Toast.makeText(
                                                context,
                                                "Hello Javatpoint",
                                                Toast.LENGTH_LONG
                                            )
                                            toast.show()
                                        }

                                    }

                                    'B' -> {
                                        if (positionTarget.equals(1)) {
                                            val toast = Toast.makeText(
                                                context,
                                                "Hello Javatpoint",
                                                Toast.LENGTH_LONG
                                            )
                                            toast.show()
//                                               customListTarget.add(positionTarget, list)
                                        }

                                    }

                                    'C' -> {
                                        if (positionTarget.equals(2)) {
                                            val toast = Toast.makeText(
                                                context,
                                                "Hello Javatpoint",
                                                Toast.LENGTH_LONG
                                            )
                                            toast.show()
//                                               customListTarget.add(positionTarget, list)
                                        }

                                    }
                                    'D' -> {
                                        if (positionTarget.equals(3)) {
                                            val toast = Toast.makeText(
                                                context,
                                                "Hello Javatpoint",
                                                Toast.LENGTH_LONG
                                            )
                                            toast.show()

                                            if (positionTarget != positionSource){
                                                listSource.add(list)
                                                adapterSource.updateList(listSource)


                                            } else{
                                                listSource.add(list)
                                                adapterSource.updateList(listSource)
                                                customListTarget[positionTarget].isclick = true
                                            }

//                                               customListTarget.add(positionTarget, list)
                                        } else {
                                            listSource.add(list)
                                            adapterSource.updateList(listSource)
                                            listener.setpostion(true)
                                            if (positionTarget != positionSource){
                                                customListTarget[positionTarget].isclick = false

                                            }else{
                                                listSource.add(list)
                                                adapterSource.updateList(listSource)
                                            }


                                            Log.e(
                                                "cutomlisttart-- ",
                                                "erererewrwerewrwerwfcewfdsfds"
                                            )

                                        }

                                    }
                                    else -> {

                                        listSource.add(list)
                                        adapterSource.updateList(listSource)
                                        Log.e("cutomlisttart-- ", "erererewrwerewrwerwfcewfdsfds")
                                    }
                                }

//                                if (positionTarget.equals(2)){
//                                    Log.e("doublcatevalue-- ","rrrrrrrrrr")
//                                    customListTarget.add(positionTarget, list)
//                                } else{
//                                    Log.e("doublcatevalue-- ","fffffff")
//                                }

                                if (positionSource.equals(positionTarget)) {
                                    customListTarget.forEach {

                                        if (it.equals(list)) {

                                            Log.e("doublcatevalue-- ", customListTarget.toString())
                                        } else {
                                            Log.e(
                                                "doublcatevalueNOT-- ",
                                                customListTarget.toString()
                                            )
                                        }
                                    }


                                }


                                Log.e("customlisttarget-- ", customListTarget.toString())
                            } else {


                                customListTarget.forEach {


                                    if (it.equals(list)) {

                                        Log.e("doublcatevalue-- ", customListTarget.toString())
                                    } else {
                                        Log.e("doublcatevalueNOT-- ", customListTarget.toString())
                                    }
                                }

                                customListTarget.add(list)
                                Log.e("cutomlisttart-- ", customListTarget.toString())
                            }
                            adapterTarget.updateList(customListTarget)
                            adapterTarget.notifyDataSetChanged()




                            if (sourceId == rvBottom && adapterSource.getItemCount() < 1) {
                                listener.setEmptyListBottom(true)
                            }
//                            if (viewId == tvEmptyListBottom) {
//                                listener.setEmptyListBottom(false)
//                            }
//                            if (sourceId == rvTop && adapterSource.getItemCount() < 1) {
//                                listener.setEmptyListTop(true)
//                            }
//                            if (viewId == tvEmptyListTop) {
//                                listener.setEmptyListTop(false)
//                            }
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