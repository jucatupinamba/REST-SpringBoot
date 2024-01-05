package com.restspringboot.RestSpringboot.services;

import com.restspringboot.RestSpringboot.exception.ResourceNotFoundException;
import com.restspringboot.RestSpringboot.model.Person;
import com.restspringboot.RestSpringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service
public class PersonServices {


    @Autowired
    private PersonRepository personRepository;
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){

        logger.info("Finding All People!");

        return personRepository.findAll();
    }

    public Person findById(Long id){
        logger.info("Find one person!");

        return personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person update(Person person){

        logger.info("Updating one person!");

        Person entity = personRepository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public Person create(Person person){

        logger.info("Create one person!");

        return personRepository.save(person);
    }

    public void delete(Long id){

        Person entity = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        personRepository.delete(entity);
        logger.info("Deleting one person!");
    }
}
