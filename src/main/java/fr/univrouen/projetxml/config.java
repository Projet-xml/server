package fr.univrouen.projetxml;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.sql.DataSource;

@Configuration
    public class config {

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://uqoklh7gy47qrqds:2pjO7NqLx8uddlLeFGD@b95t0ccdv98oglfzkygu-mysql.services.clever-cloud.com:21341/b95t0ccdv98oglfzkygu")
                .username("uqoklh7gy47qrqds")
                .password("2pjO7NqLx8uddlLeFGD")
                .build();
    }
        @Bean
        public SpringResourceTemplateResolver templateResolver() {
            SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
            templateResolver.setCacheable(false);
            templateResolver.setPrefix("classpath:/templates/");
            templateResolver.setSuffix(".html");
            return templateResolver;
        }

        @Bean
        public SpringTemplateEngine templateEngine() {
            SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
            springTemplateEngine.addTemplateResolver(templateResolver());
            return springTemplateEngine;
        }

        @Bean
        public ThymeleafViewResolver viewResolver() {
            ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
            viewResolver.setTemplateEngine(templateEngine());
            viewResolver.setOrder(1);
            return viewResolver;
        }
    }

