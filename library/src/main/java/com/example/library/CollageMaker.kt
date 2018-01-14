package com.example.library

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class CollageMaker : ViewGroup {
    companion object {
        private const val ONE = 1
        private const val TWO = 2
        private const val THREE = 3
        private const val FOUR = 4
        private const val FIVE = 5
        private const val SIX = 6
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        val listView = (0 until childCount).map { getChildAt(it) }.filter { it.visibility != View.GONE }
        val maxWidth = measuredWidth - paddingRight - paddingLeft
        val maxHeight = measuredHeight - paddingBottom - paddingTop
        when (listView.size) {
            ONE -> layoutOne(listView, maxWidth, maxHeight)
            TWO -> layoutTwo(listView, maxWidth, maxHeight)
            THREE -> layoutThree(listView, maxWidth, maxHeight)
            FOUR -> layoutFour(listView, maxWidth, maxHeight)
            FIVE -> layoutFive(listView, maxWidth, maxHeight)
            SIX -> layoutSix(listView, maxWidth, maxHeight)
        }
    }

    private fun layoutOne(listView: List<View>, maxWidth: Int, maxHeight: Int) {
        listView[0].layout(0, 0, maxWidth, maxHeight)
    }

    private fun layoutTwo(listView: List<View>, maxWidth: Int, maxHeight: Int) {
        listView[0].layout(0, 0, maxWidth, maxHeight.half())

        listView[1].layout(0, maxHeight.half(), maxWidth, maxHeight)
    }

    private fun layoutThree(listView: List<View>, maxWidth: Int, maxHeight: Int) {
        listView[0].layout(0, 0, maxWidth, maxHeight.half())

        listView[1].layout(0, maxHeight.half(), maxWidth.half(), maxHeight)
        listView[2].layout(maxWidth.half(), maxHeight.half(), maxWidth, maxHeight)
    }

    private fun layoutFour(listView: List<View>, maxWidth: Int, maxHeight: Int) {
        listView[0].layout(0, 0, maxWidth.half(), maxHeight.half())
        listView[1].layout(maxWidth.half(), 0, maxWidth, maxHeight.half())

        listView[2].layout(0, maxHeight.half(), maxWidth.half(), maxHeight)
        listView[3].layout(maxWidth.half(), maxHeight.half(), maxWidth, maxHeight)
    }

    private fun layoutFive(listView: List<View>, maxWidth: Int, maxHeight: Int) {
        listView[0].layout(0, 0, maxWidth.half(), maxHeight.third().two())

        listView[1].layout(maxWidth.half(), 0, maxWidth, maxHeight.third())
        listView[2].layout(maxWidth.half(), maxHeight.third(), maxWidth, maxHeight.third().two())

        listView[3].layout(0, maxHeight.third().two(), maxWidth.half(), maxHeight)
        listView[4].layout(maxWidth.half(), maxHeight.third().two(), maxWidth, maxHeight)
    }

    private fun layoutSix(listView: List<View>, maxWidth: Int, maxHeight: Int) {
        listView[0].layout(0, 0, maxWidth.half(), maxHeight.third())
        listView[1].layout(maxWidth.half(), 0, maxWidth, maxHeight.third())

        listView[2].layout(0, maxHeight.third(), maxWidth.half(), maxHeight.third().two())
        listView[3].layout(maxWidth.half(), maxHeight.third(), maxWidth, maxHeight.third().two())

        listView[4].layout(0, maxHeight.third().two(), maxWidth.half(), maxHeight)
        listView[5].layout(maxWidth.half(), maxHeight.third().two(), maxWidth, maxHeight)
    }

    private fun Int.half() = this / 2
    private fun Int.two() = this * 2
    private fun Int.third() = this / 3

}
