package com.kshitijpatil.kotlinarchitect.data.remote

import com.kshitijpatil.kotlinarchitect.data.model.Repository
import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

class GitRemoteDataSource {
    fun getRepositories(): Observable<ArrayList<Repository>> {
        val repositories = ArrayList<Repository>()
        repositories.add(Repository("First", "Owner 1", false, 50))
        repositories.add(Repository("Second", "Owner 2", false, 150))
        repositories.add(Repository("Third", "Owner 3", false, 200))
        return Observable.just(repositories).delay(2, TimeUnit.SECONDS)
    }
}