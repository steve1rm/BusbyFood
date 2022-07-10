package me.androidbox.busbyfood.di

import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.androidbox.domain.usecase.FetchComplexSearchUseCase
import me.androidbox.domain.usecase.imp.FetchComplexSearchUseCaseImp

@InstallIn(SingletonComponent::class)
@Module
interface UseCaseModule {

    @Reusable
    @Binds
    fun bindsFetchComplexSearchUseCase(fetchComplexSearchUseCaseImp: FetchComplexSearchUseCaseImp): FetchComplexSearchUseCase
}