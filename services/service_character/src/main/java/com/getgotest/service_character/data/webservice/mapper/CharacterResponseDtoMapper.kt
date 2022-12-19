package com.getgotest.service_character.data.webservice.mapper
import com.getgotest.service_character.data.webservice.dto.CharacterResponseDto
import com.getgotest.service_character.domain.entity.CharacterResponseEntity

class CharacterResponseDtoMapper(
    private val infoDtoMapper: InfoDtoMapper,
    private val resultDtoMapper: ResultDtoMapper
) {
    operator fun invoke(from: CharacterResponseDto): CharacterResponseEntity {
        return CharacterResponseEntity(
            infoDtoMapper(from.info),
            from.results.map {
                resultDtoMapper(it)
            }
        )
    }
}