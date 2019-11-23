package com.example.sportsbetting;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class SpringApp {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            App app = appContext.getBean(App.class);
            app.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
