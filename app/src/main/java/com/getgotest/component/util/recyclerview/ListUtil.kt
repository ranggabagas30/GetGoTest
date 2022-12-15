package com.getgotest.component.util.recyclerview

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object ListUtil {

    private fun getLinearItemDecoration(isHorizontal: Boolean, gap : Int): RecyclerView.ItemDecoration {
        return LinearSpacingItemDecoration(
            when (isHorizontal) {
                true -> LinearLayoutManager.HORIZONTAL
                false -> LinearLayoutManager.VERTICAL
            },
            gap
        )
    }

    fun getListGapDecorator(
        context: Context,
        gapSizeDp: Int,
        isHorizontal: Boolean = false
    ): RecyclerView.ItemDecoration {
        val gapFloat = (gapSizeDp * .5).toFloat()
        val gap = (gapFloat * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()

        return getLinearItemDecoration(isHorizontal, gap)
    }

}