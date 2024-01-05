package com.restspringboot.RestSpringboot.services;

import com.restspringboot.RestSpringboot.data.vo.v1.PersonVO;
import com.restspringboot.RestSpringboot.exception.ResourceNotFoundException;
import com.restspringboot.RestSpringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
@Service
public class PersonServices {


    @Autowired
    private PersonRepository personRepository;
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<PersonVO> findAll(){

        logger.info("Finding All People!");

        return personRepository.findAll();
    }

    public PersonVO findById(Long id){
        logger.info("Find one person!");

        return personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));
    }

    public PersonVO update(PersonVO person){

        logger.info("Updating one person!");

        PersonVO entity = personRepository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public PersonVO create(PersonVO person){

        logger.info("Create one person!");

        return personRepository.save(person);
    }

    public void delete(Long id){

        PersonVO entity = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        personRepository.delete(entity);
        logger.info("Deleting one person!");
    }
}
