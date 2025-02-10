package org.example.sbstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SBstarterApplication {

    public static void main(String[] args) {

        SpringApplication.run(SBstarterApplication.class, args);
    }

}
