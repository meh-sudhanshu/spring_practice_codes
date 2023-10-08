package com.herovired.Library.Management.System.repositories;

import com.herovired.Library.Management.System.models.Users;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users,Long> {

    Users findByUsername(String username);



}
