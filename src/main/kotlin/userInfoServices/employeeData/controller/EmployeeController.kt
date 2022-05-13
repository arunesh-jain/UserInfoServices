package userInfoServices.employeeData.controller

import userInfoServices.employeeData.entities.EmployeeDetailsEntities
import userInfoServices.employeeData.repositories.EmployeeDetailsRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import userInfoServices.employeeData.services.EmployeeService
import java.util.*

@RestController
class StudioDataController ( val service : EmployeeService) {

    @PostMapping("/save")
    fun addStudioDetails(@RequestBody employee: EmployeeDetailsEntities): EmployeeDetailsEntities {
        return service.addEmployee(employee)
    }


    @GetMapping("/getOne/{id}")
    fun getStudio(@PathVariable id: Int): Optional<EmployeeDetailsEntities> {
        return service.getOneEmployee(id)
    }

    @GetMapping("/getAll")
    fun getAllStudioDetails(): List<EmployeeDetailsEntities> {
        return service.getAllEmployee()
    }

    @DeleteMapping("delete/{id}")
    fun deleteEmployee(@PathVariable id: Int): HttpStatus {
        service.deleteEmployee(id)
        return HttpStatus.MOVED_PERMANENTLY
    }

    @PutMapping("/update/{Id}")
    fun updateStudioDetails(@RequestBody studio: EmployeeDetailsEntities, @PathVariable("Id") id: Int): HttpStatus {
        service.updateEmployee(studio,id)
        return HttpStatus.CREATED
    }
}