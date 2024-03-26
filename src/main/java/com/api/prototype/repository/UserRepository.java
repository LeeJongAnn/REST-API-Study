package com.api.prototype.repository;

import com.api.prototype.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findByEmail(String email);
}
