package org.zagvladimir.spring.config;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.zagvladimir.spring.config.condition.JpaCondition;

import javax.annotation.PostConstruct;

@Conditional(JpaCondition.class)
@Configuration
public class JpaConfiguration {

    @PostConstruct
    void init(){
        System.out.println("Jpa configuration is enable");
    }
}
