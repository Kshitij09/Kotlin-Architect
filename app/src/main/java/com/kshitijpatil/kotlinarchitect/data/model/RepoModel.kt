package com.kshitijpatil.kotlinarchitect.data.model

import android.os.Handler

class RepoModel {
    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        Handler().postDelayed({ onDataReadyCallback.onDataReady("New data") }, 2000)
    }

    interface OnDataReadyCallback {
        fun onDataReady(data: String)
    }
}