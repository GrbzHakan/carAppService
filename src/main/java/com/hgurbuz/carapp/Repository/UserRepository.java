package com.hgurbuz.carapp.Repository;

import com.hgurbuz.carapp.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUserName(String username);
}
