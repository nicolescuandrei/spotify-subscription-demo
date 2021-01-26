package com.andreinicolescu.spotifysubscriptiondemo.service;

import com.andreinicolescu.spotifysubscriptiondemo.entity.PlanEntity;
import com.andreinicolescu.spotifysubscriptiondemo.entity.SubscriptionEntity;
import com.andreinicolescu.spotifysubscriptiondemo.entity.UserEntity;
import com.andreinicolescu.spotifysubscriptiondemo.repository.SubscriptionRepository;
import com.andreinicolescu.spotifysubscriptiondemo.resource.dto.SubscriptionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    private final PlanService planService;

    private final UserService userService;

    public void subscribe(SubscriptionDTO subscriptionDTO) {
        PlanEntity planEntity = this.planService.getPlan(subscriptionDTO.getPlanCode());
        if (isNull(planEntity)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Plan does not exists");
        }
        UserEntity userEntity = this.userService.getUser(subscriptionDTO.getEmail());
        if (isNull(userEntity)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User does not exists");
        }
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusYears(1);
        SubscriptionEntity subscriptionEntity = SubscriptionEntity.builder()
                .plan(planEntity)
                .user(userEntity)
                .startDate(startDate)
                .endDate(endDate)
                .build();

        try {
            this.subscriptionRepository.save(subscriptionEntity);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Subscription already exists for the user", dataIntegrityViolationException);
        }
    }

}
