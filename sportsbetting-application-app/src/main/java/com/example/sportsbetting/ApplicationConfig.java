package com.example.sportsbetting;

import com.example.sportsbetting.service.SportsBettingService;
import com.example.sportsbetting.view.View;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Locale;

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
        return new View(locale);
    }

    @Value("hu_HU")
    private Locale locale;
}
