package userinfoservices.employeedata.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Employee(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    var fullName: String,
    var wordpressId: String,
    var emailId: String,
    var activeStatus: Boolean,
    var studioId: Int,
    var role: String,
    var githubId: String
)
