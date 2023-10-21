package com.codelantern.userservice.repositories;

import com.codelantern.userservice.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUserId(String userId);
}
