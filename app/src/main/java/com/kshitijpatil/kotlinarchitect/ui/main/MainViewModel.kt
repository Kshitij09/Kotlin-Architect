package com.kshitijpatil.kotlinarchitect.ui.main

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kshitijpatil.kotlinarchitect.data.RepoModel
import com.kshitijpatil.kotlinarchitect.data.model.Repository

class MainViewModel : ViewModel() {
    var repoModel = RepoModel()
    val text = ObservableField<String>("old data")
    var isLoading = ObservableField<Boolean>(false)
    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun refresh() {
        isLoading.set(true)
        repoModel.refreshData(object : RepoModel.OnDataReadyCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                text.set(data)
            }
        })
    }

    fun loadRepositories() {
        isLoading.set(true)
        repoModel.getRepositories(object : RepoModel.OnRepositoryReadyCallback {
            override fun onRepositoryReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories.value = data
            }

        })
    }
}