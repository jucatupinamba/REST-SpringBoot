package com.restspringboot.RestSpringboot.services;

import com.restspringboot.RestSpringboot.data.vo.v1.PersonVO;
import com.restspringboot.RestSpringboot.exception.ResourceNotFoundException;
import com.restspringboot.RestSpringboot.mapper.DozerMapper;
import com.restspringboot.RestSpringboot.model.Person;
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

        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        logger.info("Find one person!");

        var entity =  personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person){

        logger.info("Create one person!");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person){

        logger.info("Updating one person!");

        var entity = personRepository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }
    public void delete(Long id){

        var entity = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        personRepository.delete(entity);
        logger.info("Deleting one person!");
    }
}
