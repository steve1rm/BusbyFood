package me.androidbox.domain.responsestate

sealed class ResponseState<out T> {
    object idle: ResponseState<Nothing>()
    object Loading: ResponseState<Nothing>()
    data class Success<T>(val data: T): ResponseState<T>()
    data class Failure<T>(val error: Exception): ResponseState<T>()
}
