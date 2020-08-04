package com.talbn1.bankcrm.domain;

import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long address_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Customer customer;

    private String city;
    private String street;
    private Integer aptNumber;
    private String telephone;
    private String email;
}
