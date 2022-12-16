package com.getgotest.core.util.network

import com.getgotest.BuildConfig
import java.io.InterruptedIOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T: Any> either(block: suspend () -> T): ResponseState<T> {
    return runCatching {
        ResponseState.Success(block())
    }.getOrElse {
        ResponseState.Failed(it.getHumanReadableErrorMessage())
    }
}

fun Throwable.getHumanReadableErrorMessage(): String {
    if (BuildConfig.DEBUG) {
        printStackTrace()
    }
    return when (this) {
        is SocketTimeoutException, is InterruptedIOException, is UnknownHostException, is ConnectException -> this.message?: "Network connection is in trouble"
        is Exception -> this.message?: "Fatal error"
        else -> "Unmapped error"
    }
}