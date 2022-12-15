package com.getgotest.service_character.data.webservice.mapper

import com.getgotest.service_character.data.webservice.dto.InfoDto
import com.getgotest.service_character.domain.entity.InfoEntity

class InfoDtoMapper {
    operator fun invoke(from: InfoDto): InfoEntity {
        return InfoEntity(
            from.count?: InfoEntity.DEFAULT.count,
            from.pages?: InfoEntity.DEFAULT.pages,
            from.next?: InfoEntity.DEFAULT.next,
            from.prev?: InfoEntity.DEFAULT.prev
        )
    }
}