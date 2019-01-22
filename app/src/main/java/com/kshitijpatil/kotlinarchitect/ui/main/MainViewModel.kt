package com.kshitijpatil.kotlinarchitect.ui.main

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.kshitijpatil.kotlinarchitect.data.GitRepository
import com.kshitijpatil.kotlinarchitect.data.model.Repository
import com.kshitijpatil.kotlinarchitect.utils.NetManager
import com.kshitijpatil.kotlinarchitect.utils.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val TAG = MainViewModel::class.java.simpleName
    var gitRepository = GitRepository(NetManager(getApplication()))
    var isLoading = ObservableField<Boolean>(false)
    var repositories = MutableLiveData<ArrayList<Repository>>()
    private val compositeDisposable = CompositeDisposable()

    fun loadRepositories() {
        isLoading.set(true)
        compositeDisposable += gitRepository
            .getRepositories()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ArrayList<Repository>>() {
                override fun onComplete() {
                    isLoading.set(false)
                }

                override fun onNext(data: ArrayList<Repository>) {
                    repositories.value = data
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "Error fetching data")
                }
            })
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }
}