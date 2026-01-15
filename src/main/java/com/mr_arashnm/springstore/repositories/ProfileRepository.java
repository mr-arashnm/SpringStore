package com.mr_arashnm.springstore.repositories;

import com.mr_arashnm.springstore.dtos.UserSummary;
import com.mr_arashnm.springstore.entities.Profile;

import java.util.List;


public interface ProfileRepository extends CrudRepository<Profile, Long>{
    @EntityGraph(attributePaths = "user")
    List<UserSummary> findByLoyaltyPointsGraterThanOrderByUserEmail(int LoyaltyPoints);
}
    