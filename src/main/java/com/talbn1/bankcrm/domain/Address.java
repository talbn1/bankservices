package com.talbn1.bankcrm.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author talbn on 7/22/2020
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Column(name = "address_Id")
    @Id
    private Integer addressId;
    private String city;
    private String street;
    private String aptNumber;
    private String telephone;
    private String email;
}
