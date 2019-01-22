package com.kshitijpatil.kotlinarchitect.data.view

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.kshitijpatil.kotlinarchitect.data.model.RepoModel

class MainViewModel : ViewModel() {
    var repoModel = RepoModel()
    val text = ObservableField<String>("old data")
    var isLoading = ObservableField<Boolean>(false)

    fun refresh() {
        isLoading.set(true)
        repoModel.refreshData(object : RepoModel.OnDataReadyCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
            }
        })
    }
}