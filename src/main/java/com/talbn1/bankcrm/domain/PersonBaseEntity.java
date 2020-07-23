package com.talbn1.bankcrm.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author talbn on 7/15/2020
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonBaseEntity {

    private String firstName;
    private String lastName;
    private Long id;
    private Date dob;
}
