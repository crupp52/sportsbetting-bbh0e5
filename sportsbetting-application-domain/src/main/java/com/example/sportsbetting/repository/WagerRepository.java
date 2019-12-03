package com.example.sportsbetting.repository;

import com.example.sportsbetting.domain.Wager;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface WagerRepository extends CrudRepository<Wager, Integer> {
    List<Wager> findByPlayerId(Integer id);
}
