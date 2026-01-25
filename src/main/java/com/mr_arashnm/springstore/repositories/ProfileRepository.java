package com.mr_arashnm.springstore.repositories;

import com.mr_arashnm.springstore.dtos.UserSummary;
import com.mr_arashnm.springstore.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProfileRepository extends CrudRepository<Profile, Long> {
    @EntityGraph(attributePaths = "user")
    List<UserSummary> findByLoyaltyPointsGraterThanOrderByUserEmail(int LoyaltyPoints);
}
    