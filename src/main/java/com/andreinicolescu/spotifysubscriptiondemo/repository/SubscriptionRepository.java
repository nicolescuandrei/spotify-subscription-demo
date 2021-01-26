package com.andreinicolescu.spotifysubscriptiondemo.repository;

import com.andreinicolescu.spotifysubscriptiondemo.entity.SubscriptionEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<SubscriptionEntity, Long> {
}
