package com.getgotest.core.base

import com.getgotest.R
import com.getgotest.core.util.network.ResponseState
import com.getgotest.core.util.network.either

abstract class BaseUseCase<in P, out R: Any> {
    protected abstract suspend fun build(param: P): R
    suspend fun run(param: P): ResponseState<R> {
        return either { build(param) }
    }
}