package me.androidbox.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.androidbox.data.localstorage.InsertComplexSearch
import me.androidbox.domain.local.FoodLocal

@InstallIn(SingletonComponent::class)
@Module
interface LocalModule {

    @Binds
    fun provideInsertComplexSearch(insertComplexSearch: InsertComplexSearch): FoodLocal
}