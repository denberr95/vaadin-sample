package vaadin.sample.module.webapp.config;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "app-config")
public class AppPropertiesConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppPropertiesConfig.class);

    @Valid
    private BackendClient backendClient;

    public AppPropertiesConfig(@Valid BackendClient backendClient) {
        this.backendClient = backendClient;
    }

    @PostConstruct
    public void init() {
        if (logger.isDebugEnabled()) {
            logger.debug("Custom Application Properties Loaded: '{}'", this);
        }
    }

    public BackendClient getBackendClient() {
        return this.backendClient;
    }

    public void setBackendClient(BackendClient backendClient) {
        this.backendClient = backendClient;
    }

    @Validated
    public static class BackendClient {

        @NotNull(message = "Backend URL must not be null")
        private String url;

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
