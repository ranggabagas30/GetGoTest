package com.getgotest.core.base

abstract class BaseUseCase<in P, out R: Any> {
    protected abstract suspend fun build(param: P): R
    suspend fun run(param: P): ResponseState<R> {
        return either { build(param) }
    }
}