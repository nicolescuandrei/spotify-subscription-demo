package com.andreinicolescu.spotifysubscriptiondemo.resource.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class SubscriptionDTO {

    @NotNull
    @Email
    private String email;

    @NotNull
    private Long planCode;
}
