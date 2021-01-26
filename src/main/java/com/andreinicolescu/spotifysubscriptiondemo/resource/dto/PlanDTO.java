package com.andreinicolescu.spotifysubscriptiondemo.resource.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PlanDTO {

    private Long code;

    private String name;

    private BigDecimal price;
}
