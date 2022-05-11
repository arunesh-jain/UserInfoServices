package userInfoService.studioData.entities

import javax.persistence.*

@Entity
@Table(name = "studio_details")
class StudioEntities(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var  id : Long =0,

    @Column(name = "name", nullable = false)
    var name : String,

    @Column(name = "type")
    var type : String,

    @Column(name = "studio_head_email")
    var studioHeadEmail : String
)