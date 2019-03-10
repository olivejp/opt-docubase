package nc.opt.docubase.configuration;

import nc.opt.docubase.builder.FactoryRequestBuilder;
import nc.opt.docubase.builder.UserSessionRequestBuilder;
import nc.opt.docubase.service.UserSessionService;
import nc.opt.docubase.service.FactoryService;
import nc.opt.docubase.service.impl.UserSessionServiceImpl;
import nc.opt.docubase.service.impl.FactoryServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.URL;

@Configuration
@ConditionalOnProperty(prefix = "opt.docubase")
@EnableConfigurationProperties({DocubaseProperties.class})
public class DocubaseAutoConfiguration {

    private DocubaseProperties properties;

    public DocubaseAutoConfiguration(DocubaseProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean(UserSessionService.class)
    public FactoryService factoryService() {
        return new FactoryServiceImpl(properties);
    }

    @Bean
    public ClientHttpRequestFactory createClientHttpFactory(@Value("connect.timeout") int connectTimeout,
                                                            @Value("read.timeout") int readTimeout) {
        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpComponentsClientHttpRequestFactory.setReadTimeout(readTimeout);
        httpComponentsClientHttpRequestFactory.setConnectTimeout(connectTimeout);
        return httpComponentsClientHttpRequestFactory;
    }

    @Bean(name = "docubaseRestTemplate")
    public RestOperations restTemplate(ClientHttpRequestFactory clientHttpRequestFactory){
        return new RestTemplate(clientHttpRequestFactory);
    }

    @Bean
    public UserSessionService docubaseService() {
        return new UserSessionServiceImpl(properties);
    }

    @Bean
    public FactoryRequestBuilder factoryRequestBuilder() {
        return new FactoryRequestBuilder();
    }

    @Bean
    public UserSessionRequestBuilder userSessionRequestBuilder() {
        return new UserSessionRequestBuilder();
    }
}

