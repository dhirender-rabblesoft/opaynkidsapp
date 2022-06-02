package com.app.opaynkidsapp.listner


import android.content.Context
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.DragDropAdapter
import com.app.opaynkidsapp.model.ModelClass
import com.app.opaynkidsapp.utils.Keys

class DragDropListener internal constructor(
    listener: Listener,
    checkListner: DragDropCheckListner,
    val context: Context
) : View.OnDragListener {
    private var isDropped = false
    private val listener: Listener = listener
    private val checkListner: DragDropCheckListner = checkListner
    override fun onDrag(v: View, event: DragEvent): Boolean
    {
        when (event.action)
        {
            DragEvent.ACTION_DRAG_ENDED->
            {
                Log.e("karan","22222")
                listener.setpostion(true)
                //checkListner.isMatch(true)
                Log.e("ACTION_DRAG_ENDED",event.x.toString())
                Log.e("ACTION_DRAG_ENDEDyyy",event.y.toString())

                isDropped = true
                var positionTarget = -1
                val viewSource: View = event.localState as View
                val viewId: Int = v.getId()
                val flItem: Int = R.id.frame_layout_item
               // val tvEmptyListTop: Int = R.id.tvEmptyListTop
                 val rvTop: Int = R.id.rvTop
                when (viewId)
                {
                    flItem, rvTop, ->
                    {
                        var target: RecyclerView
                        when (viewId)
                        {
                             rvTop -> target = v.getRootView().findViewById(rvTop)
                            else ->
                            {
                                target = v.getParent() as RecyclerView
                                positionTarget = v.getTag() as Int
                                //Log.e("sourcepositions",positionTarget.toString())
                                val positionSource = viewSource.getTag() as Int


                                if (!Keys.isDrag)
                                {

                                    if (Keys.imagex.toInt()<event.x.toInt() ||Keys.imagey.toInt()<event.y.toInt())
                                    {
                                        Keys.isDrag=true
                                        val source = viewSource.getParent() as RecyclerView
                                        val adapterSource: DragDropAdapter? = source.adapter as DragDropAdapter?
                                        val sourceId = source.id
                                       // val list: ModelClass = adapterSource?.list?.get(positionSource)!!
                                        val listSource: ArrayList<ModelClass> =
                                            adapterSource?.list as ArrayList<ModelClass>
                                        // sample
                                         if (listSource[positionSource].name.equals("Apple"))
                                        {
                                             checkListner.isMatch(true)
                                        }
                                        else{
                                             checkListner.isMatch(false)
                                         }

                                    }
                                }

                                Log.e("target",positionSource.toString())
                            }
                        }
                    }
                }
            }
            DragEvent.ACTION_DRAG_STARTED->
            {
                Keys.isDrag=false
                Log.e("ACTION_DRAG_STARTED",event.x.toString())
                Log.e("ACTION_DRAG_STARTEDyyyy",event.y.toString())
            }
            DragEvent.ACTION_DROP -> {
//                Log.e("isreturntrue","lkjlkjlkjljlk")
//                isDropped = true
//                var positionTarget = -1
//                val viewSource: View = event.localState as View
//                val viewId: Int = v.getId()
//                val flItem: Int = R.id.frame_layout_item
//                val tvEmptyListTop: Int = R.id.tvEmptyListTop
//                val tvEmptyListBottom: Int = R.id.tvEmptyListBottom
//                val rvTop: Int = R.id.rvTop
//                val rvBottom: Int = R.id.rvBottom
//                when (viewId) {
//                    flItem, tvEmptyListTop, tvEmptyListBottom, rvTop, rvBottom -> {
//                        var target: RecyclerView
//                        when (viewId) {
//                            tvEmptyListTop, rvTop -> target = v.getRootView().findViewById(rvTop)
//
//                            else -> {
//
//                                target = v.getParent() as RecyclerView
//                                positionTarget = v.getTag() as Int
//                            }
//                        }
//                        if (viewSource != null) {
//                            val source = viewSource.getParent() as RecyclerView
//                            val adapterSource: ListAdapter? = source.adapter as ListAdapter?
//                            val positionSource = viewSource.getTag() as Int
//                            val sourceId = source.id
//                            val list: ModelClass = adapterSource?.list?.get(positionSource)!!
//                            val listSource: ArrayList<ModelClass> =
//                                adapterSource.list as ArrayList<ModelClass>
//                            listSource[positionSource].isdrag = false
//                            Keys.postion = positionSource
//
//                            Log.e("fistruncode", "111111111111111111")
//
//                            listSource.removeAt(positionSource)
//
//                            adapterSource.updateList(listSource)
//                            Log.e("adaptersource-- ", adapterSource.toString())
//                            adapterSource.notifyDataSetChanged()
//
//                            val adapterTarget: ListAdapter? = target.adapter as ListAdapter?
//                            val customListTarget: MutableList<ModelClass> =
//                                adapterTarget?.list as MutableList<ModelClass>
//
//
////                            if (positionTarget >= 0) {
////                                when (list.name) {
////                                    'A' -> {
////                                        if (positionTarget.equals(0)) {
////                                            val toast = Toast.makeText(
////                                                context,
////                                                "Hello Javatpoint",
////                                                Toast.LENGTH_LONG
////                                            )
////                                            toast.show()
////                                        }
////
////                                    }
////
////                                    'B' -> {
////                                        if (positionTarget.equals(1)) {
////                                            val toast = Toast.makeText(
////                                                context,
////                                                "Hello Javatpoint",
////                                                Toast.LENGTH_LONG
////                                            )
////                                            toast.show()
//////                                               customListTarget.add(positionTarget, list)
////                                        }
////
////                                    }
////
////                                    'C' -> {
////                                        if (positionTarget.equals(2)) {
////                                            val toast = Toast.makeText(
////                                                context,
////                                                "Hello Javatpoint",
////                                                Toast.LENGTH_LONG
////                                            )
////                                            toast.show()
//////                                               customListTarget.add(positionTarget, list)
////                                        }
////
////                                    }
////                                    'D' -> {
////                                        if (positionTarget.equals(3)) {
////                                            Keys.postion = positionSource
////                                            val toast = Toast.makeText(
////                                                context,
////                                                "Hello Javatpoint",
////                                                Toast.LENGTH_LONG
////                                            )
////                                            toast.show()
////                                            listSource[positionSource].isdrag = false
////                                            checkListner.isMatch(true)
////                                            customListTarget[positionTarget].isclick = true
////                                            Keys.isclick = true
//////                                               customListTarget.add(positionTarget, list)
////                                        }
////                                        else {
//////
////                                            listSource[positionSource].isdrag = false
////                                            Keys.postion = positionSource
////
////                                            adapterSource.updateList(listSource)
////                                            listener.setpostion(true)
////                                            checkListner.isMatch(false)
////                                            customListTarget[positionTarget].isclick = false
////                                            Keys.isclick = false
////                                            Log.e(
////                                                "cutomlisttart-- ",
////                                                "erererewrwerewrwerwfcewfdsfds"
////                                            )
////
////                                        }
////
////                                    }
////                                    else -> {
////
////                                      //  listSource.add(list)
////                                       // adapterSource.updateList(listSource)
////                                        Log.e("cutomlisttart-- ", "erererewrwerewrwerwfcewfdsfds")
////                                    }
////                                }
////                            } else {
////                                customListTarget.add(list)
////                            }
////                            adapterTarget.updateList(customListTarget)
////                            adapterTarget.notifyDataSetChanged()
//
//
//
//
//                            if (sourceId == rvBottom && adapterSource.getItemCount() < 1) {
//                                listener.setEmptyListBottom(true)
//                            }
//                            if (viewId == tvEmptyListBottom) {
//                                listener.setEmptyListBottom(false)
//                            }
//                            if (sourceId == rvTop && adapterSource.getItemCount() < 1) {
//                                listener.setEmptyListTop(true)
//                            }
//                            if (viewId == tvEmptyListTop) {
//                                listener.setEmptyListTop(false)
//                            }
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