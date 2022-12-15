package com.getgotest.service_character.data.webservice.mapper

import com.getgotest.service_character.data.webservice.dto.ResultDto
import com.getgotest.service_character.domain.entity.ResultEntity

class ResultDtoMapper {
    operator fun invoke(from: ResultDto): ResultEntity {
        return ResultEntity(
            from.id?: ResultEntity.DEFAULT.id,
            from.name?: ResultEntity.DEFAULT.name,
            from.status?: ResultEntity.DEFAULT.status,
            from.species?: ResultEntity.DEFAULT.species
        )
    }
}