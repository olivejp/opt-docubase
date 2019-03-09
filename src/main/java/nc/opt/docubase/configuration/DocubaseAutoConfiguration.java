package nc.opt.docubase.configuration;

import nc.opt.docubase.service.DocubaseService;
import nc.opt.docubase.service.impl.DocubaseServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({DocubaseProperties.class})
@ConditionalOnProperty(prefix = "opt.docubase", name = "enabled", havingValue = "true")
public class DocubaseAutoConfiguration {

    private DocubaseProperties properties;

    public DocubaseAutoConfiguration(DocubaseProperties properties) {
        this.properties = properties;
    }

    @Bean
    public DocubaseService docubaseService() {
        return new DocubaseServiceImpl(properties);
    }
}

