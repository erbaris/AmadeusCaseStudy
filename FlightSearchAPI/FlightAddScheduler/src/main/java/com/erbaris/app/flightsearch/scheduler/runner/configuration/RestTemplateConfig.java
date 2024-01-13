package com.erbaris.app.flightsearch.scheduler.runner.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;

@Configuration
public class RestTemplateConfig {
    @Bean
    @Scope("prototype")
    public RestTemplate createRestTemplate()
    {
        return new RestTemplate();
    }
}
