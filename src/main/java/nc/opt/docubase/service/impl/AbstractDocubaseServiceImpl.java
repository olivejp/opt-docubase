package nc.opt.docubase.service.impl;

import nc.opt.docubase.configuration.DocubaseProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

abstract class AbstractDocubaseServiceImpl {

    HttpEntity entity;
    RestOperations restTemplate;
    private DocubaseProperties properties;

    AbstractDocubaseServiceImpl(DocubaseProperties docubaseProperties, RestOperations restTemplate) {
        this.restTemplate = restTemplate;
        this.properties = docubaseProperties;

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-db-connectAs", "");
        entity = new HttpEntity<>("parameters", headers);
    }

    UriComponentsBuilder getUriBuilder() {
        return UriComponentsBuilder.fromHttpUrl(properties.getHost()).path(properties.getRestApiSegment());
    }
}
