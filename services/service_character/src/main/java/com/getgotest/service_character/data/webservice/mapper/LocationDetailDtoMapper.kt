package com.getgotest.service_character.data.webservice.mapper

import com.getgotest.service_character.data.webservice.dto.LocationDetailDto
import com.getgotest.service_character.domain.entity.LocationDetailEntity

class LocationDetailDtoMapper {
    operator fun invoke(from: com.getgotest.service_character.data.webservice.dto.LocationDetailDto): LocationDetailEntity {
        return LocationDetailEntity(
            from.id?: LocationDetailEntity.DEFAULT.id,
            from.name?: LocationDetailEntity.DEFAULT.name,
            from.type?: LocationDetailEntity.DEFAULT.type,
            from.dimension?: LocationDetailEntity.DEFAULT.dimension
        )
    }
}