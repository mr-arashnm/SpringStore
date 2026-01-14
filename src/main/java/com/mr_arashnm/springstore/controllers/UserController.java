package com.mr_arashnm.springstore.controllers;


import com.mr_arashnm.springstore.entities.User;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository

    @RequestMapping("/users")
    public Iterable<User> getAllUsers() {
        userRepository.findAll();
    }
}
