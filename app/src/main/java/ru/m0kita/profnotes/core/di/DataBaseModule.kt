package ru.m0kita.profnotes.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.m0kita.profnotes.data.local.Prefs
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun providePrefs(
        @ApplicationContext context: Context,
    ): Prefs =
        Prefs(context)
}