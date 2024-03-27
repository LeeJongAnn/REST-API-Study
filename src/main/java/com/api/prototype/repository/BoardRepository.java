package com.api.prototype.repository;

import com.api.prototype.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Integer> {

}
