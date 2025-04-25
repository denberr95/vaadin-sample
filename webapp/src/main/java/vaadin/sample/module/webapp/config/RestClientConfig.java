package vaadin.sample.module.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration(proxyBeanMethods = false)
public class RestClientConfig {

    @Bean
    RestClient restClient(AppPropertiesConfig appPropertiesConfig) {
        return RestClient.builder().baseUrl(appPropertiesConfig.getBackendClient().getUrl())
                .build();
    }
}
