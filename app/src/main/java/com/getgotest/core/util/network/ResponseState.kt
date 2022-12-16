package com.getgotest.core.util.network

sealed class ResponseState<out T: Any> {
    data class Success<out T: Any>(val data: T): ResponseState<T>()
    data class Failed(val message: String): ResponseState<Nothing>()
    object Loading : ResponseState<Nothing>()
}
