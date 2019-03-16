package nc.opt.docubase.domain.builder;


import nc.opt.docubase.domain.Domain;
import nc.opt.docubase.domain.Request;

import java.util.ArrayList;
import java.util.List;

public class RequestBuilder {

    private RequestDomainBuilder requestDomainBuilder;

    public RequestDomainBuilder idDomain(String idDomain) {
        this.requestDomainBuilder = new RequestDomainBuilder(idDomain);
        return requestDomainBuilder;
    }



    public class RequestDocument {
        private String idDocument;

        private RequestDocument(String idDocument) {
            this.idDocument = idDocument;
        }

        public Request build() {
            return new Request();
        }
    }
}
