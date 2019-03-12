package nc.opt.docubase.service.impl;

import nc.opt.docubase.configuration.DocubaseProperties;
import nc.opt.docubase.domain.GetDocumentResponse;
import nc.opt.docubase.domain.PostDocument;
import nc.opt.docubase.domain.PostDocumentResponse;
import nc.opt.docubase.service.FactoryService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

public class FactoryServiceImpl extends AbstractDocubaseServiceImpl implements FactoryService {

    private static final String PATH_FACTORY = "factory";

    public FactoryServiceImpl(DocubaseProperties docubaseProperties) {
        super(docubaseProperties);
    }

    @Override
    public ResponseEntity<GetDocumentResponse> getDomainIdList(String domainId, String baseId, String gedId) {
        return null;
    }

    @Override
    public ResponseEntity<PostDocumentResponse> getDomain(MultipartFile file, String domainId, String baseId, PostDocument postDocument) {
        return null;
    }

    @Override
    public ResponseEntity<PostDocumentResponse> getListBasesDomain(MultipartFile file, String domainId, String baseId, PostDocument postDocument) {
        return null;
    }

    @Override
    public ResponseEntity<PostDocumentResponse> getBase(MultipartFile file, String domainId, String baseId, PostDocument postDocument) {
        return null;
    }

    @Override
    public ResponseEntity<PostDocumentResponse> getBaseIndex(MultipartFile file, String domainId, String baseId, PostDocument postDocument) {
        return null;
    }

    @Override
    public ResponseEntity<PostDocumentResponse> getBaseCategory(MultipartFile file, String domainId, String baseId, PostDocument postDocument) {
        return null;
    }

    @Override
    public ResponseEntity<PostDocumentResponse> getBaseState(MultipartFile file, String domainId, String baseId, PostDocument postDocument) {
        return null;
    }

    @Override
    public ResponseEntity<PostDocumentResponse> searchUser(MultipartFile file, String domainId, String baseId, PostDocument postDocument) {
        return null;
    }

    @Override
    public ResponseEntity<PostDocumentResponse> getUserById(MultipartFile file, String domainId, String baseId, PostDocument postDocument) {
        return null;
    }
}
