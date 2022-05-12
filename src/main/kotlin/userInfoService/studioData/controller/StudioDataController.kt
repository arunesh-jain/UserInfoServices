package userInfoService.studioData.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import userInfoService.studioData.entities.StudioEntities
import userInfoService.studioData.service.StudioService
import java.util.*

@RestController
class StudioDataController ( val service : StudioService) {

    @PostMapping("/save")
    fun addStudioDetails(@RequestBody studio: StudioEntities): StudioEntities {
        return service.addStudio(studio)
    }


    @GetMapping("/getOne/{id}")
    fun getStudio(@PathVariable id: Long): Optional<StudioEntities> {
        return service.getOneStudio(id)
    }

    @GetMapping("/getAll")
    fun getAllStudioDetails(): List<StudioEntities> {
        return service.getAllStudio()
    }

    @DeleteMapping("delete/{id}")
    fun deleteEmployee(@PathVariable id: Long): HttpStatus {
        service.deleteStudioEmployee(id)
        return HttpStatus.MOVED_PERMANENTLY
    }

    @PutMapping("/update/{Id}")
    fun updateStudioDetails(@RequestBody studio: StudioEntities, @PathVariable("Id") id: Long): HttpStatus {
        service.updateStudio(studio,id)
       return HttpStatus.CREATED
    }
}