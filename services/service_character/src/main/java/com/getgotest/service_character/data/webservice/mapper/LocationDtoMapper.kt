package com.getgotest.service_character.data.webservice.mapper

import com.getgotest.service_character.data.webservice.dto.ResultDto
import com.getgotest.service_character.domain.entity.ResultEntity

class LocationDtoMapper {
    operator fun invoke(from: com.getgotest.service_character.data.webservice.dto.ResultDto.Location): ResultEntity.Location {
        return ResultEntity.Location(
            from.name?: ResultEntity.DEFAULT.location.name,
            from.url?: ResultEntity.DEFAULT.location.url
        )
    }
}