package nc.opt.docubase.domain.builder;

import nc.opt.docubase.domain.Domain;

import java.util.ArrayList;
import java.util.List;

public class RequestDomainBuilder extends AbstractRequestBuilder<RequestBaseBuilder, Domain, String> {
    private RequestBaseBuilder requestBaseBuilder;

    private RequestDomainBuilder(String idDomain) {
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
