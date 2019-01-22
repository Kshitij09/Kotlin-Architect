package com.kshitijpatil.kotlinarchitect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kshitijpatil.kotlinarchitect.data.GitRepository
import com.kshitijpatil.kotlinarchitect.ui.main.MainViewModel

class ViewModelFactory(private val repository: GitRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(repository) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}