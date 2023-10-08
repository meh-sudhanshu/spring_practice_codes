package com.example.peopleportal.services.impl;

import com.example.peopleportal.exceptions.ResourceNotFoundException;
import com.example.peopleportal.models.People;
import com.example.peopleportal.repositories.PeopleRepository;
import com.example.peopleportal.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class PeopleServiceImpl implements PeopleService {


    @Autowired
    private PeopleRepository peopleRepository;
    @Override
    public List<People> getAllPeoples() {
        return (List<People>) peopleRepository.findAll();
    }

    @Override
    public People getPeopleById(String id) {
        return peopleRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Resource does not exists")
        );
    }

    @Override
    public People savePeople(People people) {
        String randomId = UUID.randomUUID().toString();
        people.setId(randomId);
        return peopleRepository.save(people);
    }


}
