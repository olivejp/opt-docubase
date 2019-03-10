package nc.opt.docubase.service.impl;

import nc.opt.docubase.configuration.DocubaseProperties;
import nc.opt.docubase.domain.GetDocumentResponse;
import nc.opt.docubase.domain.PostDocument;
import nc.opt.docubase.domain.PostDocumentResponse;
import nc.opt.docubase.service.UserSessionService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

public class UserSessionServiceImpl implements UserSessionService {

    private static final String PATH_USER_SESSION = "usersession";

    private RestTemplate restTemplate;
    private DocubaseProperties docubaseProperties;

    public UserSessionServiceImpl(DocubaseProperties docubaseProperties) {
        this.docubaseProperties = docubaseProperties;
        this.restTemplate = new RestTemplate();
    }

    private HttpEntity<String> getHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-db-connectAs", "");
        return new HttpEntity<>("parameters", headers);
    }

    @Override
    public ResponseEntity<GetDocumentResponse> getDocumentByGedId(String domainId, String baseId, String gedId) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(docubaseProperties.getHost())
                .path(docubaseProperties.getRestApiSegment())
                .pathSegment("domain", domainId)
                .pathSegment("base", baseId)
                .pathSegment("document", gedId);

        return restTemplate.getForEntity(builder.toUriString(), GetDocumentResponse.class);
    }

    @Override
    public ResponseEntity<PostDocumentResponse> postDocument(MultipartFile file, String domainId, String baseId, PostDocument postDocument) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(docubaseProperties.getHost())
                .path(docubaseProperties.getRestApiSegment())
                .pathSegment("domain", domainId)
                .pathSegment("base", baseId)
                .queryParam("newDocumentTag", postDocument);

        return restTemplate.exchange(builder.toUriString(), HttpMethod.POST, getHttpEntity(), PostDocumentResponse.class, postDocument);
    }

    @Override
    public String getUrlDomain() {
        return docubaseProperties.getHost();
    }
}
