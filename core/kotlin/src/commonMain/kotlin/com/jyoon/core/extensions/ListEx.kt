package com.jyoon.core.extensions

fun <T> List<T>.findIndexOrNull(value: T): Int? {
    return indexOf(value).takeIf { it > -1 }
}