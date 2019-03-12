package nc.opt.docubase.service.impl;

import nc.opt.docubase.configuration.DocubaseProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

abstract class AbstractDocubaseServiceImpl {

    HttpEntity entity;
    RestOperations restTemplate;
    private DocubaseProperties properties;

    AbstractDocubaseServiceImpl(DocubaseProperties docubaseProperties) {
        this.properties = docubaseProperties;

        // Headers creation
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-db-connectAs", "");
        entity = new HttpEntity<>("parameters", headers);

        // HttpRequestFactory creation
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();

        // false when dealing with big data in POST or PUT request
        clientHttpRequestFactory.setBufferRequestBody(false);

        restTemplate = new RestTemplate(clientHttpRequestFactory);
    }

    UriComponentsBuilder getUriBuilder() {
        return UriComponentsBuilder.fromHttpUrl(properties.getHost()).path(properties.getRestApiSegment());
    }
}
