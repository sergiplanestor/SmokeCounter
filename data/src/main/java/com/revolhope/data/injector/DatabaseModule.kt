package com.revolhope.data.injector

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.revolhope.data.common.storage.database.dao.ProjectDao
import com.revolhope.data.common.storage.database.db.SmokeCounterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(
        context: Context
    ): SmokeCounterDatabase =
        Room.databaseBuilder(context, SmokeCounterDatabase::class.java, "smoke-counter-database").build()

    @Singleton
    @Provides
    fun providesProjectDao(
        database: SmokeCounterDatabase
    ) : ProjectDao = database.provideProjectDao()
}