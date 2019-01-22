package com.kshitijpatil.kotlinarchitect.di

import com.kshitijpatil.kotlinarchitect.KotlinArchitect
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        MainActivityModule::class,
        ViewModelBuilder::class]
)
interface AppComponent : AndroidInjector<KotlinArchitect> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<KotlinArchitect>()
}