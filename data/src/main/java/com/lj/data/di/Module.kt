package com.lj.data.di

import com.lj.data.repository.MediaRepositoryImpl
import com.lj.domain.repository.MediaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Module to inject/provide repositories.
 */
@InstallIn(SingletonComponent::class)
@Module
object Module {

    /**
     * Provide the implementation of [MediaRepository].
     */
    @Provides
    fun provideMediaRepository(): MediaRepository {
        return MediaRepositoryImpl()
    }
}