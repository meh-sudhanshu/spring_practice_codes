package com.herovired.Library.Management.System.repositories;

import com.herovired.Library.Management.System.models.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserDataRepository extends CrudRepository<UserData,Long> {
    UserData findByUsername(String username);
}
