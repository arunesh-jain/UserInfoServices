package UserInfoServices.EmployeeData.repositories

import UserInfoServices.EmployeeData.entities.Employee
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeDetailsRepository : CrudRepository<Employee,String>