package com.getgotest.service_character.data.webservice.mapper

import com.getgotest.service_character.data.webservice.dto.ResultDto
import com.getgotest.service_character.domain.entity.ResultEntity

class ResultDtoMapper(
    private val locationDtoMapper: LocationDtoMapper
) {
    operator fun invoke(from: com.getgotest.service_character.data.webservice.dto.ResultDto): ResultEntity {
        return ResultEntity(
            from.id?: ResultEntity.DEFAULT.id,
            from.name?: ResultEntity.DEFAULT.name,
            from.status?: ResultEntity.DEFAULT.status,
            from.species?: ResultEntity.DEFAULT.species,
            from.gender?: ResultEntity.DEFAULT.gender,
            from.origin?.let { locationDtoMapper(it) }?: ResultEntity.DEFAULT.origin,
            from.location?.let { locationDtoMapper(it) }?: ResultEntity.DEFAULT.location,
            from.image?: ResultEntity.DEFAULT.image,
            from.episodes?: ResultEntity.DEFAULT.episode
        )
    }
}