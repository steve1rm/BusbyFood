package me.androidbox.data.di

import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.androidbox.data.repository.RepositoryImp
import me.androidbox.data.request.RequestComplexSearch
import me.androidbox.domain.remote.FoodRemote
import me.androidbox.domain.remote.Repository

@Module
@InstallIn(SingletonComponent::class)
interface SearchModule {

    @Reusable
    @Binds
    fun bindsFoodRemote(requestComplexSearch: RequestComplexSearch): FoodRemote

    @Reusable
    @Binds
    fun bindsRepository(repositoryImp: RepositoryImp): Repository
}