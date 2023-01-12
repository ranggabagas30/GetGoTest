package com.getgotest.di.router

import com.getgotest.di.router.feature_character.CharacterDetailRouterImpl
import com.getgotest.di.router.feature_character.CharacterListRouterImpl
import com.getgotest.feature_character.sub.character_detail.CharacterDetailContract
import com.getgotest.feature_character.sub.character_list.CharacterListContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object RouterModule {

    @Provides
    @ActivityScoped
    fun provideCharacterListRouter(): CharacterListContract.Router =
        CharacterListRouterImpl()

    @Provides
    @ActivityScoped
    fun provideCharacterDetailRouter(): CharacterDetailContract.Router =
        CharacterDetailRouterImpl()
}