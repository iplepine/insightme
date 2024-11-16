package com.jyn.insightme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform