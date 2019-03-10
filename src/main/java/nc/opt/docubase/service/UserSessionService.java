package nc.opt.docubase.service;

import nc.opt.docubase.domain.GetDocumentResponse;
import nc.opt.docubase.domain.PostDocument;
import nc.opt.docubase.domain.PostDocumentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UserSessionService {
    ResponseEntity<GetDocumentResponse> getDocumentByGedId(String domainId, String baseId, String gedId);

    ResponseEntity<PostDocumentResponse> postDocument(MultipartFile file, String domainId, String baseId, PostDocument postDocument);

    String getUrlDomain();
}