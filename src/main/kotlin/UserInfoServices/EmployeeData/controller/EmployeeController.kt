package UserInfoServices.EmployeeData.controller

import UserInfoServices.EmployeeData.entities.EmployeeDetailsEntities
import UserInfoServices.EmployeeData.repositories.EmployeeDetailsRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

class EmployeeController (val repo : EmployeeDetailsRepository) {
    @PostMapping("/save")
    fun addEmployeeDetails(@RequestBody employee: EmployeeDetailsEntities): EmployeeDetailsEntities {
        return repo.save(employee)
    }

    @GetMapping("/getAll")
    fun getAllEmployeesDetails(): List<EmployeeDetailsEntities> {
        return repo.findAll().toList()
    }

    @DeleteMapping("/delete/{Id}")
    fun deleteEmployeeDetails(@PathVariable(value = "Id") Id: String): HttpStatus {
        repo.deleteById(Id)
        return HttpStatus.MOVED_PERMANENTLY
    }
}