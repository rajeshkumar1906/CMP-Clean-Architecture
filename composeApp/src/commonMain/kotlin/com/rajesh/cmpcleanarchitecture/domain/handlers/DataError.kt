package com.rajesh.cmpcleanarchitecture.domain.handlers

sealed interface DataError: Error{
    enum class Remote: DataError{
        STATUS_ERROR,
        REQUEST_TIMED_OUT
    }
}