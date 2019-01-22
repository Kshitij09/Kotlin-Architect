package com.kshitijpatil.kotlinarchitect.data

import com.kshitijpatil.kotlinarchitect.data.model.Repository
import com.kshitijpatil.kotlinarchitect.utils.NetManager
import io.reactivex.Observable

class GitRepository(val netManager: NetManager) {
    val localDataSource = GitLocalDataSource()
    val remoteDataSource = GitRemoteDataSource()
    fun getRepositories(): Observable<ArrayList<Repository>> {
        netManager.isConnectedToInternet?.let {
            return if (it) {
                remoteDataSource.getRepositories().flatMap {
                    return@flatMap localDataSource
                        .saveRepositories(it)
                        .toSingleDefault(it)
                        .toObservable()
                }
            } else {
                localDataSource.getRepositories()
            }
        }
    }
}