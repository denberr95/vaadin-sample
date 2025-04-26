package vaadin.sample.module.backend.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "app-config")
public final class AppPropertiesConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppPropertiesConfig.class);

    @PostConstruct
    public void init() {
        if (logger.isDebugEnabled()) {
            logger.debug("Custom Application Properties Loaded: '{}'", this);
        }
    }
}
