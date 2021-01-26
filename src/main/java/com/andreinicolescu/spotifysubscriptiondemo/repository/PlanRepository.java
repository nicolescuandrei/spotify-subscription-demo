package com.andreinicolescu.spotifysubscriptiondemo.repository;

import com.andreinicolescu.spotifysubscriptiondemo.entity.PlanEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlanRepository extends CrudRepository<PlanEntity, Long> {

    @Override
    List<PlanEntity> findAll();

    PlanEntity findByCode(Long code);
}
