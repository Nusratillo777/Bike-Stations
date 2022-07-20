package com.nusratillo.testtask.ui.custom_view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.nusratillo.testtask.R

class InfoWithCountView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {
    private val iconIV: ImageView
    private val titleTV: TextView
    private val countTV: TextView

    init {
        inflate(context, R.layout.view_info_with_count, this)
        iconIV = findViewById(R.id.icon_iv)
        titleTV = findViewById(R.id.title_tv)
        countTV = findViewById(R.id.count_tv)

        initView(attrs)
    }

    fun setCountText(count: String) {
        countTV.text = count
    }

    private fun initView(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.InfoWithCountView)
        val icon = typedArray.getDrawable(R.styleable.InfoWithCountView_iconDrawable)
        val titleText = typedArray.getString(R.styleable.InfoWithCountView_titleText)
        val countTextColor = typedArray.getColor(
            R.styleable.InfoWithCountView_countColor,
            ContextCompat.getColor(context, android.R.color.black)
        )

        iconIV.setImageDrawable(icon)
        titleTV.text = titleText
        countTV.setTextColor(countTextColor)

        typedArray.recycle()
    }
}