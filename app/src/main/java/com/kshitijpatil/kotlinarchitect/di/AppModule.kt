package com.kshitijpatil.kotlinarchitect.di

import android.content.Context
import com.kshitijpatil.kotlinarchitect.KotlinArchitect
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun providesContext(application: KotlinArchitect): Context {
        return application.applicationContext
    }
}