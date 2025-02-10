package org.example.sbstarter.configuration;

import lombok.Getter;
import lombok.Setter;
import org.example.sbstarter.configuration.enums.LogLevel;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "http.logging")
public class HttpConfigurationProperties {

    private boolean logEnabled;

    private LogLevel logLevel;

}
