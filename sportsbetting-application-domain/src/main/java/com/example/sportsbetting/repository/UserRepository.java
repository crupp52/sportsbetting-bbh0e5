package com.example.sportsbetting.repository;

import com.example.sportsbetting.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
