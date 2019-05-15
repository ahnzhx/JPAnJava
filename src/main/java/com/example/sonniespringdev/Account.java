package com.example.sonniespringdev;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Account {

    @Id @GeneratedValue
    private Long id;
    @Column
    private String username;
    private String password;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street", column = @Column(name="home_street"))
    })
    private Address address;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public void addStudy(Study study) {
        this.getStudies().add(study);
    }

    public void removeStudy(Study study){
        this.getStudies().remove(study);
    }
}
