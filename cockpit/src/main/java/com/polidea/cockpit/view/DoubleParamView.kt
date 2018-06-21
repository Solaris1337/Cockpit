package com.polidea.cockpit.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import com.polidea.cockpit.R
import com.polidea.cockpit.exception.CockpitFormatException
import kotlinx.android.synthetic.main.cockpit_number_param_line.view.*

@SuppressLint("ViewConstructor")
class DoubleParamView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0,
                      override val paramName: String) : ParamView<Double>, LinearLayout(context, attrs, defStyleAttr) {

    override var value: Double = 0.0
        get() {
            try {
                return (getValueView() as EditText).text.toString().toDouble()
            } catch (e: NumberFormatException) {
                throw CockpitFormatException()
            }
        }
        set(value) {
            field = value
            cockpit_number_param_value.setText(value.toString())
        }

    override fun getValueView(): View = cockpit_number_param_value

    override fun getRestoreButton(): View = cockpit_number_param_restore_button

    init {
        LayoutInflater.from(context).inflate(R.layout.cockpit_number_param_line, this, true)
        cockpit_number_param_name.text = paramName
        cockpit_number_param_name.isSelected = true
    }
}