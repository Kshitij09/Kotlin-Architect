package com.kshitijpatil.kotlinarchitect.di

import androidx.lifecycle.ViewModelProvider
import com.kshitijpatil.kotlinarchitect.DaggerAwareViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelBuilder {
    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerAwareViewModelFactory): ViewModelProvider.Factory
}