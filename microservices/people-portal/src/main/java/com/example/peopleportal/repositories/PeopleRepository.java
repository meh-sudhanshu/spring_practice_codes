package com.example.peopleportal.repositories;

import com.example.peopleportal.models.People;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<People,String> {
}
