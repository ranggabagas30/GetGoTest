package com.getgotest.service_character.internal

import com.getgotest.service_character.data.webservice.service.CharacterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideCharacterApi(retrofit: Retrofit): CharacterApi = retrofit.create(CharacterApi::class.java)
}