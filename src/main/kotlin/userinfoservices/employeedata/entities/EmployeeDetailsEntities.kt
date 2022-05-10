package userinfoservices.employeedata.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table (name = "employee_details")
class EmployeeDetailsEntities(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,
    @Column (name = "full_name")
    var fullName: String,

    @Column (name = "wordpress_id")
    var wordpressId: String,

    @Column (name = "email_id")
    var emailId: String,

    @Column (name = "active_status")
    var activeStatus: Boolean,

    @Column (name = "studio_id")
    var studioId: Int,

    @Column (name = "role")
    var role: String,

    @Column (name = "github_id")
    var githubId: String
)
