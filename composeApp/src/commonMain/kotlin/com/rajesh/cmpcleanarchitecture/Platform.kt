package com.rajesh.cmpcleanarchitecture

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform