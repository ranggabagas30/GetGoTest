package com.getgotest.core.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.getgotest.core.contract.RouterContract

open class BaseRouter : RouterContract {
    override fun <S : Activity, D : Activity> navigateTo(
        activity: S,
        destinationActivity: Class<D>,
        param: Bundle?
    ) {
        activity.run {
            startActivity(
                Intent(this, destinationActivity).apply {
                    param?.also {
                        putExtras(it)
                    }
                }
            )
        }
    }
}