package com.example.sportsbetting.config;

import com.example.sportsbetting.App;
import com.example.sportsbetting.service.SportsBettingService;
import com.example.sportsbetting.view.View;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.example.sportsbetting.repository")
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

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source;
        source = new ResourceBundleMessageSource();
        source.setBasenames("messages/labels");
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }
}
