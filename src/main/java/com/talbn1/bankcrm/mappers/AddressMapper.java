package com.talbn1.bankcrm.mappers;

import com.talbn1.bankcrm.domain.Address;
import com.talbn1.bankcrm.domain.Customer;
import com.talbn1.bankcrm.dtomodel.AddressDto;
import com.talbn1.bankcrm.dtomodel.CustomerDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author talbn on 8/8/2020
 **/

@Component
public class AddressMapper {

    public Address addressDtoToEntitiy(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        } else {
            Address.AddressBuilder address = Address.builder();
            address.aptNumber(addressDto.getAptNumber());
            address.city(addressDto.getCity());
            return address.build();
        }
    }

    public CustomerDto addressEntityToDto(Address address) {
        if (address == null) {
            return null;
        } else {
            CustomerDto.CustomerDtoBuilder customerDto = CustomerDto.builder();
/*            customerDto.customerId(address.getCustomerId());
            customerDto.firstName(address.getFirstName());
            customerDto.lastName(address.getLastName());
            customerDto.creditGrade(address.getCreditGrade());*/
            return customerDto.build();
        }
    }

}
