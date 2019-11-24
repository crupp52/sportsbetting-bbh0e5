package com.example.sportsbetting;

import com.example.sportsbetting.config.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Locale;

@ComponentScan(basePackages = "com.example")
@Component
public class SpringApp {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    static private MessageSource messageSource;

    public static void main(String[] args) throws IOException {

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        App app = ctx.getBean(App.class);
        app.setLocale(Locale.ENGLISH);

        messageSource = ctx.getBean(ResourceBundleMessageSource.class);
        app.setMessageSource(messageSource);
        app.setLogger(logger);
        app.play();

        ctx.close();
    }
}
