package userInfoService.studioData.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import userInfoService.studioData.entities.StudioEntities
import userInfoService.studioData.repositories.StudioDetailsRepository

@RestController
class StudioDataController ( val repo : StudioDetailsRepository) {

    @PostMapping( "/save")
    fun addStudioDetails (@RequestBody studio : StudioEntities) : StudioEntities {
        return  repo.save(studio)
    }

    @GetMapping ("/getAll")
    fun getAllStudioDetails() : List<StudioEntities> {
        return repo.findAll().toList()
    }

    @DeleteMapping ("/delete/{id}")
    fun deleteStudioDetails (@PathVariable(value = "Id") Id: String) : HttpStatus {
        repo.deleteById(Id)
        return HttpStatus.MOVED_PERMANENTLY
    }
}