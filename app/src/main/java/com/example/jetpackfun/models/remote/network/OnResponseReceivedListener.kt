package com.example.jetpackfun.models.remote.network

interface OnResponseReceivedListener {

    fun onSuccessReceived(response: Any?)
    fun onFailureReceived(errorMessage: String?)
}