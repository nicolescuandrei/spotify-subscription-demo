package com.andreinicolescu.spotifysubscriptiondemo.resource;

import com.andreinicolescu.spotifysubscriptiondemo.service.SubscriptionService;
import com.andreinicolescu.spotifysubscriptiondemo.resource.dto.SubscriptionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionResourceController {

    private final SubscriptionService subscriptionService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void subscribe(@RequestBody SubscriptionDTO subscriptionDTO) {
        this.subscriptionService.subscribe(subscriptionDTO);
    }
}
