package com.restspringboot.RestSpringboot.services;

import com.restspringboot.RestSpringboot.data.vo.v1.PersonVO;
import com.restspringboot.RestSpringboot.data.vo.v2.PersonVOV2;
import com.restspringboot.RestSpringboot.exception.ResourceNotFoundException;
import com.restspringboot.RestSpringboot.mapper.DozerMapper;
import com.restspringboot.RestSpringboot.model.Person;
import com.restspringboot.RestSpringboot.repository.PersonRepository;
import com.restspringboot.RestSpringboot.unittests.mapper.custom.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
@Service
public class PersonServices {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper mapper;

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

    public PersonVOV2 createV2(PersonVOV2 personVOV2){

        logger.info("Create one person with V2!");
        var entity = mapper.convertVOToEntity(personVOV2);
        var vo = mapper.convertEntityToVO(personRepository.save(entity));
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
