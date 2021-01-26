package com.andreinicolescu.spotifysubscriptiondemo.resource;

import com.andreinicolescu.spotifysubscriptiondemo.service.PlanService;
import com.andreinicolescu.spotifysubscriptiondemo.resource.dto.PlanDTO;
import com.github.dozermapper.core.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/plans")
@RequiredArgsConstructor
public class PlanResourceController {

    private final PlanService planService;

    private final Mapper mapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PlanDTO> getPlans() {
        return this.planService.getPlans()
                .stream()
                .map(planEntity -> this.mapper.map(planEntity, PlanDTO.class))
                .collect(Collectors.toList());
    }
}
