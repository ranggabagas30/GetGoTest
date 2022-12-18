package com.getgotest.service_character.domain.usecase

import com.getgotest.core.base.BaseUseCase
import com.getgotest.service_character.domain.entity.LocationDetailEntity
import com.getgotest.service_character.domain.repository.CharacterRepository
import javax.inject.Inject

class GetLocationDetailUseCase @Inject constructor(
    private val repository: CharacterRepository
): BaseUseCase<Int, LocationDetailEntity>() {
    override suspend fun build(param: Int): LocationDetailEntity {
        return repository.getLocation(param)
    }
}