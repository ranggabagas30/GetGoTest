package com.getgotest.core.contract

import android.app.Activity
import android.os.Bundle

interface RouterContract {
    fun <S: Activity, D: Activity> navigateTo(
        activity: S,
        destinationActivity: Class<D>,
        param: Bundle? = null
    )
}