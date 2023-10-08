package com.example.peopleportal.services;

import com.example.peopleportal.models.People;

import java.util.List;

public interface PeopleService {


    List<People> getAllPeoples();

    People getPeopleById(String id);

    People savePeople(People people);

}
