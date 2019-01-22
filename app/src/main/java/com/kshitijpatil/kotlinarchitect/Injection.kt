package com.kshitijpatil.kotlinarchitect

import android.content.Context
import com.kshitijpatil.kotlinarchitect.data.GitRepository
import com.kshitijpatil.kotlinarchitect.utils.NetManager

object Injection {
    //This is memory leak !!
    private var NET_MANAGER: NetManager? = null

    fun provideMainViewModelFactory(context: Context): ViewModelFactory {
        val netManager = provideNetManager(context)
        val repository = provideGitRepository(netManager)
        return ViewModelFactory(repository)
    }

    private fun provideNetManager(context: Context): NetManager {
        if (NET_MANAGER == null) {
            NET_MANAGER = NetManager(context)
        }
        return NET_MANAGER!!
    }

    private fun provideGitRepository(netManager: NetManager): GitRepository {
        return GitRepository(netManager)
    }
}