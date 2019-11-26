package com.example.sportsbetting.repository;

import com.example.sportsbetting.domain.FootballSportEvent;
import org.springframework.data.repository.CrudRepository;

public interface FootballSportEventRepository extends CrudRepository<FootballSportEvent, Integer> {
}
