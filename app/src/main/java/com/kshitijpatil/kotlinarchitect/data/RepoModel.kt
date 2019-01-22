package com.kshitijpatil.kotlinarchitect.data

import android.os.Handler
import com.kshitijpatil.kotlinarchitect.data.model.Repository

class RepoModel {
    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        Handler().postDelayed({ onDataReadyCallback.onDataReady("New data") }, 2000)
    }

    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback) {
        val repositories = ArrayList<Repository>()
        repositories.add(Repository("First", "Owner 1", false, 50))
        repositories.add(Repository("Second", "Owner 2", false, 150))
        repositories.add(Repository("Third", "Owner 3", false, 200))
        Handler().postDelayed({ onRepositoryReadyCallback.onRepositoryReady(repositories) }, 2000)
    }

    interface OnDataReadyCallback {
        fun onDataReady(data: String)
    }

    interface OnRepositoryReadyCallback {
        fun onRepositoryReady(data: ArrayList<Repository>)
    }
}