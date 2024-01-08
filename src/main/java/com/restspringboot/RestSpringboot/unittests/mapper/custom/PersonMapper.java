package com.restspringboot.RestSpringboot.unittests.mapper.custom;

import com.restspringboot.RestSpringboot.data.vo.v2.PersonVOV2;
import com.restspringboot.RestSpringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVO(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthDay(new Date());

        return vo;
    }

    public Person convertVOToEntity(PersonVOV2 personVOv2){
        Person vo = new Person();
        vo.setId(personVOv2.getId());
        vo.setFirstName(personVOv2.getFirstName());
        vo.setLastName(personVOv2.getLastName());
        vo.setAddress(personVOv2.getAddress());
        vo.setGender(personVOv2.getGender());


        return vo;
    }
}
