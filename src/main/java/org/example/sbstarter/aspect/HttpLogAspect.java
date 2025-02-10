package org.example.sbstarter.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.example.sbstarter.configuration.HttpConfigurationProperties;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class HttpLogAspect {
    private final HttpConfigurationProperties configurationProperties;

    public HttpLogAspect(HttpConfigurationProperties configuration){
        this.configurationProperties = configuration;
    }

    @Pointcut("@annotation(org.example.sbstarter.aspect.loggable.Loggable)")
    public void logExecutionMethods() {}

    @Before("logExecutionMethods()")
    public void logRequest(JoinPoint joinPoint) {
        log("Is it request!");
    }

    @AfterReturning("logExecutionMethods()")
    public void logResponse(JoinPoint joinPoint){
        log("Is it response");
    }

    private void log(String message){
        switch (configurationProperties.getLogLevel()){
            case INFO:
                log.info(message);
                break;
            case DEBUG:
                log.debug(message);
                break;
            case WARN:
                log.warn(message);
                break;
            case ERROR:
                log.error(message);
                break;
            default:
                throw new RuntimeException("Недопустимое свойство LogLevel:: " + configurationProperties.getLogLevel());
        }
    }
}
