package com.getgotest.core.util

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import java.text.DecimalFormat

fun ImageView.customSetImage(
    imageSource : Any?,
    defaultErrorImage : Drawable? = null,
    saveCache : Boolean = true,
    invalidate : Boolean = false
) {
    when(imageSource){
        is String -> {
            if (invalidate) {
                val picasso = Picasso.get()
                picasso.load(imageSource.ifEmpty { "null" }).noFade().noPlaceholder().setMemoryPolicy(saveCache).into(this)
                picasso.invalidate(imageSource.ifEmpty { "null" })
            } else {
                if (imageSource.isNotEmpty()) Picasso.get().load(imageSource).setMemoryPolicy(true).into(this,
                    object : Callback {
                        override fun onSuccess() {

                        }

                        override fun onError(e: java.lang.Exception?) {
                            defaultErrorImage?.let {
                                this@customSetImage.setImageDrawable(it)
                            }
                        }
                    })
            }
        }
        is Int -> {
            try {
                this.setImageDrawable(ContextCompat.getDrawable(context, imageSource))
            }catch (e : Exception){

            }
        }
        is Drawable -> { this.setImageDrawable(imageSource) }
        is Bitmap -> this.setImageBitmap(imageSource)
    }
}

fun Long.convertDelimitedNumber(useDot: Boolean = true, usePrefix : Boolean = true): String {
    var value = DecimalFormat("#,###").format(this)

    if (useDot) {
        value = value.replace(",", ".")
    }

    return if (usePrefix) "Rp $value" else value
}

fun RequestCreator.setMemoryPolicy(saveCache : Boolean): RequestCreator {
    return if (!saveCache) memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) else this
}

fun getViewBitmap(view: View): Bitmap {
    //Get the dimensions of the view so we can re-layout the view at its current size
    //and create a bitmap of the same size
    val width = 1080
    val height = 1920
    val measuredWidth = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY)
    val measuredHeight = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)

    //Cause the view to re-layout
    view.measure(measuredWidth, measuredHeight)
    view.layout(0, 0, view.measuredWidth, view.measuredHeight)

    //Create a bitmap backed Canvas to draw the view into
    val b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val c = Canvas(b)

    //Now that the view is laid out and we have a canvas, ask the view to draw itself into the canvas
    view.draw(c)
    return b
}