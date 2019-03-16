package nc.opt.docubase.domain.builder;

import nc.opt.docubase.domain.Document;
import nc.opt.docubase.domain.Domain;

import java.util.ArrayList;
import java.util.List;

public class RequestDocumentBuilder extends AbstractParentRequestBuilder<RequestBaseBuilder, Document, String> {
    private RequestBaseBuilder requestBaseBuilder;

    private RequestDocumentBuilder(String idDomain) {
        super(idDomain);
    }

    @Override
    public List<Domain> getAll() {
        return new ArrayList<>();
    }

    public RequestBaseBuilder idBase(String idBase) {
        this.requestBaseBuilder = new RequestBaseBuilder(idBase);
        return this.requestBaseBuilder;
    }
}
