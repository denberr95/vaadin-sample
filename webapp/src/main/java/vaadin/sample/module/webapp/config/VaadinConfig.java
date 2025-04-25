package vaadin.sample.module.webapp.config;

import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class VaadinConfig {

    @Bean
    Clock clock() {
        return Clock.systemDefaultZone();
    }
}
