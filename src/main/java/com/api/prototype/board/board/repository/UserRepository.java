package com.api.prototype.board.board.repository;

import com.api.prototype.board.board.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
