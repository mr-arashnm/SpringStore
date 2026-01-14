package com.mr_arashnm.springstore.services;

import com.mr_arashnm.springstore.entities.User;
import com.mr_arashnm.springstore.repositories.UserRepository;


@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Tranactional
    public void ShowEntityStates() {
        var user = User.builder()
                .name("john Doe")
                .email("john.deo@example.com")
                .password("password")
                .build();

        if (entityManager.contain(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

    }
}