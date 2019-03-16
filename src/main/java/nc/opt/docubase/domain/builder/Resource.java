package nc.opt.docubase.domain.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Une ressource est un élément dans une url qui correspond à un élément métier
 * par exemple /domain/{domainId}/base/{baseId}  domain et base sont des ressources
 *
 * @param <S> Classe de sortie de la ressource
 */
public abstract class Resource<S> {
    private String resourceName;
    private List<Resource> childrenResource;

    public Resource(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

    protected void addChildResource(Resource childResource) {
        if (childrenResource == null) {
            childrenResource = new ArrayList<>();
        }
        childrenResource.add(childResource);
    }
}
