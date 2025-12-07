package com.mr_arashnm.springstore;


public interface UserRepository {
    void save(User user);
    User findByEmail(String email);

}
