package com.getgotest.service_character.data.webservice.mapper

import com.getgotest.service_character.data.webservice.dto.EpisodeDto
import com.getgotest.service_character.domain.entity.EpisodeEntity

class EpisodeDtoMapper {
    operator fun invoke(from: EpisodeDto): EpisodeEntity {
        return EpisodeEntity(
            from.id?: EpisodeEntity.DEFAULT.id,
            from.name?: EpisodeEntity.DEFAULT.name,
            from.airDate?: EpisodeEntity.DEFAULT.airDate,
            from.episode?: EpisodeEntity.DEFAULT.episode,
            from.characters?: EpisodeEntity.DEFAULT.characters
        )
    }
}