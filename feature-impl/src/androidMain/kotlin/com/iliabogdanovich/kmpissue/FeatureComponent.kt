package com.iliabogdanovich.kmpissue

import dagger.Binds
import dagger.Component
import dagger.Module

interface FeatureApi {
    val feature: Feature
}

@Module
interface FeatureModule {
    @Binds
    fun feature(impl: FeatureImpl): Feature
}

@Component(modules = [FeatureModule::class])
interface FeatureComponent : FeatureApi {
    companion object {
        fun create() = DaggerFeatureComponent.create()
    }
}
