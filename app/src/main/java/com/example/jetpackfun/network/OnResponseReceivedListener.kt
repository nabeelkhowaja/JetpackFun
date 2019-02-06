package com.example.jetpackfun.network

interface OnResponseReceivedListener {
    fun onSuccessReceived(response: Any?)
    fun onFailureReceived(errorMessage: String?)
}