package com.mr_arashnm.springstore.services;

import com.mr_arashnm.springstore.entities.Address;
import com.mr_arashnm.springstore.entities.User;
import com.mr_arashnm.springstore.repositories.AddressRepository;
import com.mr_arashnm.springstore.repositories.ProfileRepository;
import com.mr_arashnm.springstore.repositories.UserRepository;


@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;

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
    @Tranactional
    public void ShowRelatedEntities(Address address) {
        var profile = profileRepository.findBy(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress() {
        var address = addressRepository.findAll(1L).orElseThrow();
    }

    public void persistRelated() {
            var user = User.builder()
                    .name("john Doe")
                    .email("john.deo@example.com")
                    .password("password")
                    .build();

            var address = Address.builder()
                    .street("street")
                    .city("city")
                    .state("state")
                    .zip("zip")
                    .build();

            user.addAddress(address);

            userRepository.save(user);
    }
    @Transactional
    public void deleteRelated() {
        var user = userRepository.findBy(3L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);

    }
}