package com.herovired.Library.Management.System.repositories;

import com.herovired.Library.Management.System.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUserName(String username);
}
