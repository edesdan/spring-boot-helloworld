package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


/**
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 * @Configuration tags the class as a source of bean definitions for the application context.
 * @EnableAutoConfiguration tells Spring Boot to start adding beans based on classpath settings,
 * other beans, and various property settings. Normally you would add @EnableWebMvc for a Spring MVC app,
 * but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a
 * web application and activates key behaviors such as setting up a DispatcherServlet.
 * @ComponentScan tells Spring to look for other components, configurations, and services in the hello package,
 * allowing it to find the controllers. The main() method uses Spring Boot’s SpringApplication.run() method to
 * launch an application. Did you notice that there wasn’t a single line of XML? No web.xml file either.
 * This web application is 100% pure Java and you didn’t have to deal with configuring any plumbing or infrastructure.
 * <p>
 * There is also a CommandLineRunner method marked as a @Bean and this runs on start up.
 * It retrieves all the beans that were created either by your app or were automatically added thanks to Spring Boot.
 * It sorts them and prints them out.
 */

@SpringBootApplication
public class HelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
}
