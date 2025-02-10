package org.example.sbstarter.configuration;

import org.example.sbstarter.aspect.HttpLogAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HttpConfigurationProperties.class)
public class HttpLogConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public HttpLogAspect httpLogAspect(HttpConfigurationProperties configurationProperties){
        return new HttpLogAspect(configurationProperties);
    }
}
