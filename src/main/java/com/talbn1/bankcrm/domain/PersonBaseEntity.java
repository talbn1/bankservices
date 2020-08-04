package com.talbn1.bankcrm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author talbn on 7/15/2020
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class PersonBaseEntity {

    public PersonBaseEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long person_id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
