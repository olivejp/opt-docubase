package nc.opt.docubase.domain.builder;

import nc.opt.docubase.domain.Domain;

import java.util.List;

public class DomainResource extends Resource<Domain> implements GetMethodInterface<String, Domain> {

    private static final String RESOURCE_NAME = "domain";

    public DomainResource() {
        super(RESOURCE_NAME);
    }

    @Override
    public Domain get(String idToGet) {
        return null;
    }

    @Override
    public List<Domain> getAll() {
        return null;
    }
}
