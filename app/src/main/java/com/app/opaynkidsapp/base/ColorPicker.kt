package com.app.opaynkidsapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.app.opaynkidsapp.R
import com.app.opaynkidsapp.adapter.ColorPickerAdapter
import com.app.opaynkidsapp.databinding.ActivityColorPickerBinding
import com.app.opaynkidsapp.viewmodel.ColorPickerModel
import kotlinx.android.synthetic.main.activity_color_picker.*

class ColorPicker(var baseActivity: KotlinBaseActivity, val itemClick: (Int) -> Unit) :
    DialogBaseFragment() {
    lateinit var binding: ActivityColorPickerBinding
    var colorAdapter: ColorPickerAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.activity_color_picker, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        colorAdapter()
        setClick()

    }

    private fun setClick() {
        colorcancelbutton.setOnClickListener {
            dismiss()
        }
    }


    private fun colorAdapter() {
        val colorlist = ArrayList<ColorPickerModel>()
        colorlist.add(ColorPickerModel(R.color.red_color))
        colorlist.add(ColorPickerModel(R.color.cyan_color))
        colorlist.add(ColorPickerModel(R.color.ligh_blue_color))
        colorlist.add(ColorPickerModel(R.color.purple_color))
        colorlist.add(ColorPickerModel(R.color.yellow_color))
        colorlist.add(ColorPickerModel(R.color.lime_color))
        colorlist.add(ColorPickerModel(R.color.megenta_color))
        colorlist.add(ColorPickerModel(R.color.pink_color))
        colorlist.add(ColorPickerModel(R.color.silver_color))
        colorlist.add(ColorPickerModel(R.color.green_color))
        colorlist.add(ColorPickerModel(R.color.black_color))
        colorlist.add(ColorPickerModel(R.color.orange_color))
        colorlist.add(ColorPickerModel(R.color.brown_color))
        colorlist.add(ColorPickerModel(R.color.maroon_color))
        colorlist.add(ColorPickerModel(R.color.green_color))
        colorlist.add(ColorPickerModel(R.color.olive_color))
        colorlist.add(ColorPickerModel(R.color.aquamarine_color))


        colorAdapter = ColorPickerAdapter(baseActivity) {
            itemClick(colorlist[it].colorcode)
            dismiss()

        }
        binding.rvColors.adapter = colorAdapter
        colorAdapter?.addNewList(colorlist)
    }
}