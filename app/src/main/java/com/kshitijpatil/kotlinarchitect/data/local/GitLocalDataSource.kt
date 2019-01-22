package com.kshitijpatil.kotlinarchitect.data.local

import com.kshitijpatil.kotlinarchitect.data.model.Repository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class GitLocalDataSource {
    fun getRepositories(): Observable<ArrayList<Repository>> {
        val repositories = ArrayList<Repository>()
        repositories.add(Repository("First", "Owner 1", false, 50))
        repositories.add(Repository("Second", "Owner 2", false, 150))
        repositories.add(Repository("Third", "Owner 3", false, 200))
        return Observable.just(repositories).delay(2, TimeUnit.SECONDS)
    }

    fun saveRepositories(arrayList: ArrayList<Repository>): Completable {
        return Single.just(1).delay(1, TimeUnit.SECONDS).ignoreElement()
    }
}