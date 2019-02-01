package com.example.jetpackfun.network

import java.util.*

interface OnResponseReceivedListener {
    fun onSuccessReceived(response: Any?)
    fun onFailureReceived(errorMessage: String)
}