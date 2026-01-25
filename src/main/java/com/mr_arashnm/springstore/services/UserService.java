package com.mr_arashnm.springstore.services;

import com.mr_arashnm.springstore.entities.Address;
import com.mr_arashnm.springstore.entities.Product;
import com.mr_arashnm.springstore.entities.User;
import com.mr_arashnm.springstore.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void ShowEntityStates() {
        var user = User.builder()
                .name("john Doe")
                .email("john.deo@example.com")
                .password("password")
                .build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

    }
    @Transactional
    public void ShowRelatedEntities(Address address) {
        var profile = profileRepository.findById(2L).orElseThrow();
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
        var user = userRepository.findById(3L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void manageProducts() {
        profileRepository.deleteById(4L);
    }

    @Transactional
    public void updateProductPrice() {
        productRepository.updatePriceWithCategory(BigDecimal.valueOf(10), (byte(1));
    }

    @Transactional
    public void fetchProducts() {
        var product = new Product();
        product.setName("product");

        var matcher = ExampleMatcher.matching()
                .withIncludeNullValues()
                .withIgnorePaths("id", "description")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        var example = Example.of(product.matcher);
        var products = ProductRepository.findAll(example);
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchUsers() {
        var users = userRepository.findAllWithTags();
        users.forEach(u -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }

    @Transactional
    public void printLoyalProfiles(){
        var users = UserRepository.findLoyalUsers(2);
        users.forEach(p -> System.out.println(p.getEmail() + ": " + p.getEmail()));
    }
}