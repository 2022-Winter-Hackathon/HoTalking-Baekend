package com.hypeboy.HoTalking.global.restTemplate;

import com.hypeboy.HoTalking.global.config.properties.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final RestTemplateBuilder restTemplateBuilder;
    private final AppProperties appProperties;

    private RestTemplate restTemplate(final String endpoint) {
        return restTemplateBuilder.rootUri(endpoint)
                .additionalInterceptors(new RestTemplateRequestInterceptor())
                .errorHandler(new RestTemplateErrorHandler())
                .setConnectTimeout(Duration.ofMinutes(2))
                .build();
    }

    @Bean
    public RestTemplate authTemplate() {
        return restTemplate(appProperties.getAuth_url());
    }

    @Bean
    public RestTemplate openTemplate() {
        return restTemplate(appProperties.getOpen_api_url());
    }

}