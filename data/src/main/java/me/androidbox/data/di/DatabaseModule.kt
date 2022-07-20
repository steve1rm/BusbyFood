package me.androidbox.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.androidbox.data.localstorage.FoodDao
import me.androidbox.data.localstorage.FoodDatabase
import me.androidbox.data.utils.Constant
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DatabaseModule {
    companion object {
        @Provides
        @Singleton
        fun provideRoomDatabase(@ApplicationContext context: Context): FoodDatabase {
            return Room
                .databaseBuilder(context, FoodDatabase::class.java, Constant.DATABASE_NAME)
                .build()
        }

        @Provides
        @Singleton
        fun provideFoodDao(foodDatabase: FoodDatabase): FoodDao {
            return foodDatabase.foodDao()
        }
    }
}
