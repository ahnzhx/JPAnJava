package com.example.sonniespringdev;


import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    private Set<Study> studies = new HashSet();

    public void addStudy(Study study) {
        this.getStudies().add(study);
    }

    public void removeStudy(Study study){
        this.getStudies().remove(study);
    }
}
