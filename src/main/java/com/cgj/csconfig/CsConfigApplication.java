package com.cgj.csconfig;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

@SpringBootApplication
@RestController
public class CsConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsConfigApplication.class, args);
    }

    @Value("${testValue}")
    private String testValue;

    @GetMapping(value = "get")
    public String get(){
        return testValue;
    }


    @Configuration
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public static class MyPropertySourceLocator implements PropertySourceLocator {


        @SneakyThrows
        @Override
        public PropertySource<?> locate(Environment environment) {
            Properties properties = new Properties();

            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\MyData\\IdeaProjects\\csconfig\\src\\main\\resources\\my-properties.properties"));

            properties.load(bufferedReader);
            /*Map<String,Object> map = new HashMap<String,>(properties);*/

            PropertiesPropertySource propertySource = new PropertiesPropertySource("my-property-source",properties);
            return propertySource;
        }
    }

}
