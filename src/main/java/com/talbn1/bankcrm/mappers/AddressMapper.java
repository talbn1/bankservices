package com.talbn1.bankcrm.mappers;

import com.talbn1.bankcrm.domain.Address;
import com.talbn1.bankcrm.dtomodel.AddressDto;
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
            address.email(addressDto.getEmail());
            address.street(addressDto.getStreet());
            address.telephone(addressDto.getTelephone());
            return address.build();
        }
    }

    public AddressDto addressEntityToDto(Address address) {
        if (address == null) {
            return null;
        } else {
            AddressDto.AddressDtoBuilder addressDto = AddressDto.builder();
            addressDto.aptNumber(address.getAptNumber());
            addressDto.city(address.getCity());
            addressDto.email(address.getEmail());
            addressDto.telephone(address.getTelephone());
            return addressDto.build();
        }
    }
}
