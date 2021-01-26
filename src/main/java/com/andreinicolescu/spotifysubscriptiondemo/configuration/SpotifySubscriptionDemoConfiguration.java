package com.andreinicolescu.spotifysubscriptiondemo.configuration;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifySubscriptionDemoConfiguration {

    @Bean
    public Mapper getDozerMapper() {
        return DozerBeanMapperBuilder.buildDefault();
    }
}
