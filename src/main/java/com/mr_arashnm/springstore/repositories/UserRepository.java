package com.mr_arashnm.springstore.repositories;

import com.mr_arashnm.springstore.dtos.UserSummary;
import com.mr_arashnm.springstore.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = "addresses")
    @Query("select u from User u")
    List<User> findAllWithTags();

    @Query("select u.id as id, u.user.email as email from User u where u.profile.loyaltyPoints > : loyaltyPoints order by u.email")
    @EntityGraph(attributePaths = "user")
    static List<UserSummary> findLoyalUsers(@Param("loyaltyPoints") int loyaltyPoints) {
        return null;
    }
}
