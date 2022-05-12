package userInfoService.studioData.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import userInfoService.studioData.entities.StudioEntities
import userInfoService.studioData.repositories.StudioDetailsRepository

@Service
class StudioService (val repo : StudioDetailsRepository) {
    fun addStudio(studio: StudioEntities): StudioEntities {
        return repo.save(studio)
    }

    fun getOneStudio(id: Long): java.util.Optional<StudioEntities> {
        return repo.findById(id)
    }

    fun getAllStudio(): List<StudioEntities> {
        return repo.findAll().toList()
    }

    fun deleteStudioEmployee(id: Long): HttpStatus {
        repo.deleteById(id)
        return HttpStatus.MOVED_PERMANENTLY
    }

    fun updateStudio(studio: StudioEntities, id: Long) {
        val task = repo.findById(id).orElse(null)
        val updatedStudio = repo.save(
            task.apply {
                name = studio.name
                type = studio.type
                studioHeadEmail = studio.studioHeadEmail

            }
        )
    }
}

