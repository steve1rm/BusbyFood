package me.androidbox.busbyfood.di

import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.androidbox.domain.usecase.FetchComplexSearchPagingUseCase
import me.androidbox.domain.usecase.FetchComplexSearchUseCase
import me.androidbox.domain.usecase.InsertComplexSearchUseCase
import me.androidbox.domain.usecase.imp.FetchComplexSearchPagingUseCaseImp
import me.androidbox.domain.usecase.imp.FetchComplexSearchUseCaseImp
import me.androidbox.domain.usecase.imp.InsertComplexSearchUseCaseImp

@InstallIn(SingletonComponent::class)
@Module
interface UseCaseModule {

    @Reusable
    @Binds
    fun bindsFetchComplexSearchUseCase(fetchComplexSearchUseCaseImp: FetchComplexSearchUseCaseImp): FetchComplexSearchUseCase

    @Reusable
    @Binds
    fun bindsInsertComplexSearchUseCase(insertComplexSearchUseCaseImp: InsertComplexSearchUseCaseImp): InsertComplexSearchUseCase

    @Reusable
    @Binds
    fun bindsFetchComplexSearchPagingUseCase(fetchComplexSearchPagingUseCaseImp: FetchComplexSearchPagingUseCaseImp): FetchComplexSearchPagingUseCase
}