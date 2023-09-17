package com.example.springdatajpa.repositories;

import com.example.springdatajpa.models.TestModel;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<TestModel,Long> {
}
