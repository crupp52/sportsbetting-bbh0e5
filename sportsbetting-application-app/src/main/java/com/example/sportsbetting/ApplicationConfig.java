package com.example.sportsbetting;

import com.example.sportsbetting.service.SportsBettingService;
import com.example.sportsbetting.view.View;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public App app() {
        return new App(sportsBettingService(), view());
    }

    @Bean
    public SportsBettingService sportsBettingService() {
        return new SportsBettingService();
    }

    @Bean
    public View view() {
        return new View();
    }
}
