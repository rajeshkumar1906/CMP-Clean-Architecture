package com.rajesh.cmpcleanarchitecture.domain.logger

interface Logger{
    fun debug(message: String)
    fun info(message: String)
    fun warn(message: String)
    fun error(message: String, throwable: Throwable)

}