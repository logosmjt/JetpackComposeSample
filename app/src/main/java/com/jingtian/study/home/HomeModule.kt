package com.jingtian.study.home

import com.jingtian.study.repository.FeatureRepository
import com.jingtian.study.repository.MockFeatureRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideFeatureRepository(): FeatureRepository {
        return MockFeatureRepository()
    }
}
