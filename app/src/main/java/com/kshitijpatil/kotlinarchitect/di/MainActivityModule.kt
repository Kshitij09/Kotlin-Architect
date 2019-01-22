package com.kshitijpatil.kotlinarchitect.di

import androidx.lifecycle.ViewModel
import com.kshitijpatil.kotlinarchitect.ui.main.MainActivity
import com.kshitijpatil.kotlinarchitect.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @ContributesAndroidInjector()
    internal abstract fun mainActivity(): MainActivity
}
