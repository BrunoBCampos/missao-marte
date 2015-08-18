package br.com.elo7.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages="br.com.elo7")
@EnableAutoConfiguration
@EnableJpaRepositories
@EntityScan(basePackages="br.com.elo7.dominio")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}