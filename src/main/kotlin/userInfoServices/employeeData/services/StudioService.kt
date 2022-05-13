package userInfoServices.employeeData.services

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import userInfoServices.employeeData.entities.EmployeeDetailsEntities
import userInfoServices.employeeData.repositories.EmployeeDetailsRepository

@Service
class EmployeeService (val repo : EmployeeDetailsRepository) {
    fun addEmployee(employee: EmployeeDetailsEntities): EmployeeDetailsEntities {
        return repo.save(employee)
    }

    fun getOneEmployee(id: Int): java.util.Optional<EmployeeDetailsEntities> {
        return repo.findById(id)
    }

    fun getAllEmployee(): List<EmployeeDetailsEntities> {
        return repo.findAll().toList()
    }

    fun deleteEmployee(id: Int): HttpStatus {
        repo.deleteById(id)
        return HttpStatus.MOVED_PERMANENTLY
    }

    fun updateEmployee(employee: EmployeeDetailsEntities, id: Int) {
        val task = repo.findById(id).orElse(null)
        val updatedStudio = repo.save(
            task.apply {
                fullName = employee.fullName
                wordpressId=employee.wordpressId
                emailId=employee.emailId
                activeStatus=employee.activeStatus
                studioId=employee.studioId
                role=employee.role
                githubId=employee.githubId
            }
        )
    }
}
