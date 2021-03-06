package nc.opt.docubase.service;

import nc.opt.docubase.domain.GetDocumentResponse;
import nc.opt.docubase.domain.PostDocument;
import nc.opt.docubase.domain.PostDocumentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserSessionService {

    List<String> getDomainIdList();

    GetDocumentResponse getDocumentByGedId(String domainId, String baseId, String gedId);

    PostDocumentResponse postDocument(MultipartFile file, String domainId, String baseId, PostDocument postDocument);
}