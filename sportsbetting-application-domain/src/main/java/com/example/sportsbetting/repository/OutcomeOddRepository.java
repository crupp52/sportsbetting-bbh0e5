package com.example.sportsbetting.repository;

import com.example.sportsbetting.domain.OutcomeOdd;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OutcomeOddRepository extends CrudRepository<OutcomeOdd, Integer> {
}
