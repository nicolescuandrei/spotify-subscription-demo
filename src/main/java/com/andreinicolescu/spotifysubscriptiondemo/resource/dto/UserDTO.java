package com.andreinicolescu.spotifysubscriptiondemo.resource.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;
}
