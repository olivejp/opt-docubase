package nc.opt.docubase.service;

import nc.opt.docubase.domain.GetDocumentResponse;
import nc.opt.docubase.domain.PostDocument;
import nc.opt.docubase.domain.PostDocumentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FactoryService {
    ResponseEntity<GetDocumentResponse> getDomainIdList(String domainId, String baseId, String gedId);

    ResponseEntity<PostDocumentResponse> getDomain(MultipartFile file, String domainId, String baseId, PostDocument postDocument);

    ResponseEntity<PostDocumentResponse> getListBasesDomain(MultipartFile file, String domainId, String baseId, PostDocument postDocument);

    ResponseEntity<PostDocumentResponse> getBase(MultipartFile file, String domainId, String baseId, PostDocument postDocument);

    ResponseEntity<PostDocumentResponse> getBaseIndex(MultipartFile file, String domainId, String baseId, PostDocument postDocument);

    ResponseEntity<PostDocumentResponse> getBaseCategory(MultipartFile file, String domainId, String baseId, PostDocument postDocument);

    ResponseEntity<PostDocumentResponse> getBaseState(MultipartFile file, String domainId, String baseId, PostDocument postDocument);

    ResponseEntity<PostDocumentResponse> searchUser(MultipartFile file, String domainId, String baseId, PostDocument postDocument);

    ResponseEntity<PostDocumentResponse> getUserById(MultipartFile file, String domainId, String baseId, PostDocument postDocument);
}