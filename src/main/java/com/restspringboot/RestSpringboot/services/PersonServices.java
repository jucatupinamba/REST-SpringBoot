package com.restspringboot.RestSpringboot.services;

import com.restspringboot.RestSpringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
@Service
public class PersonServices {


    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){

        logger.info("Finding All People!");
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            Person person = mockPerson(i);
            persons.add(person);

        }
        return persons;

    }

    public Person findById(String id){
        logger.info("Find one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Juca ");
        person.setLastName("Martins");
        person.setAddress("RUa Cantareira, 281");
        person.setGender("Masculino");
        return person;
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person Name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Some address in Brasil " + i);
        person.setGender("Some gender " + i);
        return person;
    }
}
