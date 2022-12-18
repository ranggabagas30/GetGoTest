package com.getgotest.service_character.domain.usecase

import com.getgotest.core.base.BaseUseCase
import com.getgotest.service_character.domain.entity.EpisodeEntity
import com.getgotest.service_character.domain.repository.CharacterRepository
import javax.inject.Inject

class GetEpisodeUseCase @Inject constructor(
    private val repository: CharacterRepository
): BaseUseCase<Int, EpisodeEntity>() {
    override suspend fun build(param: Int): EpisodeEntity {
        return repository.getEpisode(param)
    }
}