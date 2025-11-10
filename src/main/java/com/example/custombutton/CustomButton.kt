package com.example.custombutton

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.custombutton.databinding.CustomBtnLayoutBinding

class CustomButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var binding: CustomBtnLayoutBinding =
        CustomBtnLayoutBinding.inflate(LayoutInflater.from(context), this)

    init {
        orientation = HORIZONTAL

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomButton)
        val text = typedArray.getString(R.styleable.CustomButton_btnText)
        val icon = typedArray.getResourceId(R.styleable.CustomButton_btnIcon, 0)
        typedArray.recycle()

        binding.buttonText.text = text ?: ""
        if (icon != 0) {
            binding.buttonIcon.setImageResource(icon)
            binding.buttonIcon.visibility = VISIBLE
        } else {
            binding.buttonIcon.visibility = GONE
        }
    }

    fun setText(text: String) {
        binding.buttonText.text = text
    }

    fun setIcon(resId: Int) {
        binding.buttonIcon.setImageResource(resId)
        binding.buttonIcon.visibility = VISIBLE
    }

    fun setOnClickListener(action: () -> Unit) {
        binding.buttonRoot.setOnClickListener { action() }
    }
}
