package nc.opt.docubase.domain.builder;

import nc.opt.docubase.domain.Base;
import nc.opt.docubase.domain.Document;
import nc.opt.docubase.domain.Request;

public class RequestBaseBuilder extends AbstractParentRequestBuilder<RequestBuilder.RequestDocument, Base, String> {
    private String idBase;
    private RequestBuilder.RequestDocument requestDocument;

    private RequestBaseBuilder(String idBase) {
        this.idBase = idBase;
    }

    private String getIdBase() {
        return idBase;
    }

    private RequestBuilder.RequestDocument getRequestDocument() {
        return requestDocument;
    }

    public void idDocument(String idDocument) {
        this.requestDocument = new RequestBuilder.RequestDocument(idDocument);
    }

    public Request build() {
        return new Request();
    }
}
