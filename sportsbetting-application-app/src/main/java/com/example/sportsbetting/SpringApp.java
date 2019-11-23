package com.example.sportsbetting;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class SpringApp {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(SpringApp.class);

        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {
            App app = appContext.getBean(App.class);
            logger.warn("Program Started");
            app.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
