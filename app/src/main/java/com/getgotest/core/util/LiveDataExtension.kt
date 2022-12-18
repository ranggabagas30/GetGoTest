package com.getgotest.core.util

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<MutableList<T>>.add(data: T) {
    val tempList = mutableListOf<T>()
    tempList.addAll(this.value?: listOf())
    tempList.add(data)
    this.value = tempList
}