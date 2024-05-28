package com.bci.users.mapper;

import com.bci.users.dto.PhoneDto;
import com.bci.users.entity.Phone;

public class PhoneMapper {
    public static Phone mapPhoneDtoToPhone (PhoneDto phoneDto){
        Phone phone = new Phone();
        phone.setNumber(phoneDto.getNumber());
        phone.setCitycode(phoneDto.getCitycode());
        phone.setCountrycode(phoneDto.getCountrycode());

        return phone;
    }
}
