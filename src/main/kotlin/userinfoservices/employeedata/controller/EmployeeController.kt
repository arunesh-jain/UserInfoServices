package userinfoservices.employeedata.controller

import userinfoservices.employeedata.entities.Employee
import userinfoservices.employeedata.repositories.EmployeeRepositories
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeController (val repo : EmployeeRepositories)
{
    @PostMapping("/save")
    fun addEmployeeDetails(@RequestBody employee: Employee): Employee {
        return repo.save(employee)
    }
    @GetMapping("/getAll")
    fun getAllEmployeesDetails() : List<Employee>
    {
        return repo.findAll().toList()
    }
    @DeleteMapping("/delete/{Id}")
    fun deleteEmployeeDetails(@PathVariable (value = "Id") Id: String): HttpStatus {
        repo.deleteById(Id)
        return HttpStatus.MOVED_PERMANENTLY
    }


}

