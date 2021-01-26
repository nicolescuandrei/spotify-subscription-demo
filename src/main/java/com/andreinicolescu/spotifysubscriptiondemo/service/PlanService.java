package com.andreinicolescu.spotifysubscriptiondemo.service;

import com.andreinicolescu.spotifysubscriptiondemo.entity.PlanEntity;
import com.andreinicolescu.spotifysubscriptiondemo.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;

    public List<PlanEntity> getPlans() {
        return this.planRepository.findAll();
    }

    public PlanEntity getPlan(Long code) {
        return this.planRepository.findByCode(code);
    }
}
