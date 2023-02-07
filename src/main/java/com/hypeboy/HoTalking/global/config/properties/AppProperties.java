package com.hypeboy.HoTalking.global.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("app")
public class AppProperties {

    private String SECRET_KEY;

    private String client_id;

    private String client_secret;

    private String auth_url;

    private String open_api_url;

}