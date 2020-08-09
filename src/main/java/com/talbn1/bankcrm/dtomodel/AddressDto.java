package com.talbn1.bankcrm.dtomodel;
import com.talbn1.bankcrm.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;


/**
 * @author talbn on 8/6/2020
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

    @Null
    private Long address_id;

    private String city;

    private String street;

    private Integer aptNumber;

    private String telephone;

    private String email;
}
