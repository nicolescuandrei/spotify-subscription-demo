package com.andreinicolescu.spotifysubscriptiondemo.resource;

import com.andreinicolescu.spotifysubscriptiondemo.resource.dto.UserDTO;
import com.andreinicolescu.spotifysubscriptiondemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserResourceController {

    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody UserDTO userDTO) {
        this.userService.saveUser(userDTO);
    }
}
