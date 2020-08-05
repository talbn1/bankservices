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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id_fk")
    private Customer customer;

    private String city;
    private String street;
    private Integer aptNumber;
    private String telephone;
    private String email;
}
