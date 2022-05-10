package userInfoService.studioData.repositories

import org.springframework.data.repository.CrudRepository
import userInfoService.studioData.entities.StudioEntities

interface StudioDetailsRepository : CrudRepository<StudioEntities, String>