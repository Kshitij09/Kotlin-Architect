package com.kshitijpatil.kotlinarchitect

import com.kshitijpatil.kotlinarchitect.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class KotlinArchitect : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

}