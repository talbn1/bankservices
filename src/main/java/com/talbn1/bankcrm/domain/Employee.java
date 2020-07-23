package com.talbn1.bankcrm.domain;

import lombok.*;

/**
 * @author talbn on 7/15/2020
 **/

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class Employee extends PersonBaseEntity {

    private String bankId;
    private Integer salary;



}
