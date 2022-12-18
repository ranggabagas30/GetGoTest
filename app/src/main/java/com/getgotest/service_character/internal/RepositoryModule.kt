package com.getgotest.service_character.internal

import com.getgotest.service_character.data.webservice.mapper.*
import com.getgotest.service_character.data.webservice.repository.CharacterRepositoryImpl
import com.getgotest.service_character.data.webservice.service.CharacterApi
import com.getgotest.service_character.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideCharacterRepository(
        characterApi: CharacterApi
    ): CharacterRepository =
        CharacterRepositoryImpl(
            characterApi,
            CharacterResponseDtoMapper(
                InfoDtoMapper(),
                ResultDtoMapper(
                    LocationDtoMapper()
                )
            ),
            EpisodeDtoMapper()
        )
}