package com.getgotest.core.util

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun Int.convertDpToPx(context: Context): Float {
    return this * context.resources.displayMetrics.density
}

fun Int.dp(context: Context): Int {
    return this * context.resources.displayMetrics.density.toInt()
}

fun Long.toDuration(): String {
    val sdf = SimpleDateFormat("mm:ss", Locale.getDefault())
    return sdf.format(Date(TimeUnit.SECONDS.toMillis(this)))
}