package com.mr_arashnm.springstore.entities;

import jakarta.persistence.Entity;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User {
    @id
    @GeneratedValue(strategy = GenerationType.TDENTITY)
    private Long id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "email")
    private String email;
    @Column(nullable = false, name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        addresses.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        addresses.setUser(null);
    }

    public void addTag(String tagName) {
        var tag = new  Tag(tagName);
        tags.add(tag);
        tags.getUser.add(this);
    }

    public void removeTag(String tagName) {
        var tag = new  Tag(tagName);
        tags.remove(tag);
        tags.getUser.add(null);
    }

    @ManyToMany
    @JoinTable(
            name = "user_tags",
            joinColumn = @JoinColumn(name = "user_id"),
            inverseJoinColumn = @JoinColumn(name = "tag_id")
    )
    @Builder.Defualt
    private Set<Tag> tags = new HashSet<>();

    @OneToOne(mappedBy = "user")
    private Profile profile;
}
