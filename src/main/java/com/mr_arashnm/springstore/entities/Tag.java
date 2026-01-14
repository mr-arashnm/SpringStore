package com.mr_arashnm.springstore.entities;


import javax.annotation.processing.Generated;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Biulder
@Entity
@Table(name = "tags")
public class Tag {
    @id
    @GeneratedValue(strategy = GenerateionType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    @ToString.Exclude
    private Set<User> users = new HashSet<>();

    public Tag(String name) {
        this.name = name;
    }
}