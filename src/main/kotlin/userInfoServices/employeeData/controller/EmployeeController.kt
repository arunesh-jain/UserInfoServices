package userInfoServices.employeeData.controller

import userInfoServices.employeeData.entities.EmployeeDetailsEntities
import userInfoServices.employeeData.repositories.EmployeeDetailsRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class EmployeeController (val repo : EmployeeDetailsRepository) {
    @PostMapping("/save")
    fun addEmployeeDetails(@RequestBody employee: EmployeeDetailsEntities): EmployeeDetailsEntities {
        return repo.save(employee)
    }
    @GetMapping("/getOne/{id}")
    fun getOneEmployee(@PathVariable id: Int): Optional<EmployeeDetailsEntities> {
        return repo.findById(id)
    }

    @GetMapping("/getAll")
    fun getAllEmployeesDetails(): List<EmployeeDetailsEntities> {
        return repo.findAll().toList()
    }

    @DeleteMapping("/delete/{Id}")
    fun deleteEmployeeDetails(@PathVariable(value = "Id") Id: Int): HttpStatus {
        repo.deleteById(Id)
        return HttpStatus.MOVED_PERMANENTLY
    }
    @PutMapping("/update/{Id}")
    fun updateEmployeeDetails(@RequestBody employee: EmployeeDetailsEntities, @PathVariable Id: Int): HttpStatus {

        val task = repo.findById(Id).orElse(null)
        val updatedEmployeeDetails = repo.save(
            task.apply {
                fullName = employee.fullName
                wordpressId = employee.wordpressId
                emailId = employee.emailId
                activeStatus = employee.activeStatus
                studioId = employee.studioId
                role = employee.role
                githubId = employee.githubId
            }
        )
        return HttpStatus.CREATED
    }
}
