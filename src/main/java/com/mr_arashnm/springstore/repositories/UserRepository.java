package com.mr_arashnm.springstore.repositories;

import com.mr_arashnm.springstore.entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findByEmail(String email);
}
