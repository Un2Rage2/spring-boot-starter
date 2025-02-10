package org.example.sbstarter.configuration.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import java.util.Arrays;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum LogLevel {

    INFO(0, "ИНФО"), DEBUG(1, "ОТЛАДКА"), WARN(2, "ПРЕДУПРЕЖДЕНИЕ"), ERROR(3, "ОШИБКА");

    private final String title;
    private final int value;

    LogLevel (int value, String title){
        this.title = title;
        this.value = value;
    }

    @JsonCreator
    static LogLevel findValue(@JsonProperty("value") String value) {
        try {
            int x = Integer.parseInt(value);
            return Arrays.stream(LogLevel.values()).filter(v -> v.getValue() == x).findFirst().get();
        } catch (Exception s) {
            return LogLevel.valueOf(value);
        }
    }
}
