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

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoveal = true)
    @Builder.Default
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_tags",
            joinColumn = @JoinColumn(name = "user_id"),
            inverseJoinColumn = @JoinColumn(name = "tag_id")
    )
    @Builder.Defualt
    private Set<Tag> tags = new HashSet<>();

    @OneToOne(mappedBy = "user")
    private Profile profile;

    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumn = @JoinColumn(name = "user_id"),
            inverseJoinColumn = @JoinColumn(name = "product_id")
    )
    private Set<Product> wishlist = new HashSet<>();

    public void addWishList(Product product) {
        wishlist.add(product);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " +id + ", " +
                "name = " + name + ", " +
                "email = " + email + ")";
    }
}
