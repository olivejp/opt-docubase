package nc.opt.docubase.service.impl;

import nc.opt.docubase.configuration.DocubaseProperties;
import nc.opt.docubase.domain.GetDocumentResponse;
import nc.opt.docubase.domain.PostDocument;
import nc.opt.docubase.domain.PostDocumentResponse;
import nc.opt.docubase.service.UserSessionService;
import org.springframework.http.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

public class UserSessionServiceImpl extends AbstractDocubaseServiceImpl implements UserSessionService {

    private static final String PATH_USER_SESSION = "usersession";


    public UserSessionServiceImpl(DocubaseProperties docubaseProperties, RestOperations restTemplate) {
        super(docubaseProperties, restTemplate);
    }

    @Override
    public GetDocumentResponse getDocumentByGedId(String domainId, String baseId, String gedId) {
        UriComponentsBuilder builder = getUriBuilder()
                .path(PATH_USER_SESSION)
                .pathSegment("domain", domainId)
                .pathSegment("base", baseId)
                .pathSegment("document", gedId);

        return restTemplate.getForEntity(builder.toUriString(), GetDocumentResponse.class).getBody();
    }

    @Override
    public PostDocumentResponse postDocument(MultipartFile file, String domainId, String baseId, PostDocument postDocument) {
        UriComponentsBuilder builder = getUriBuilder()
                .path(PATH_USER_SESSION)
                .pathSegment("domain", domainId)
                .pathSegment("base", baseId)
                .queryParam("newDocumentTag", postDocument);

        return restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, PostDocumentResponse.class, postDocument).getBody();
    }
}
