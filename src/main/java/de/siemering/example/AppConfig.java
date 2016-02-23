package de.siemering.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("de.siemering.example")
public class AppConfig {

    private static final Logger log = LogManager.getLogger("AppConfig.class");

    public AppConfig() {
        log.trace("AppConfig created");
    }
}
