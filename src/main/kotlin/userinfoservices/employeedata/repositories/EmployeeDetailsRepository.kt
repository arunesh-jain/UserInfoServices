package userinfoservices.employeedata.repositories

import userinfoservices.employeedata.entities.Employee
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepositories : CrudRepository<Employee,String>