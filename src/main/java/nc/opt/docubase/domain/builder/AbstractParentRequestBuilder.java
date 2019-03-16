package nc.opt.docubase.domain.builder;

import nc.opt.docubase.domain.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param <T1> Type de request inclue (exemple un type RequestDomainBuilder peut contenir une RequestBaseBuilder...)
 * @param <T2> Variable de sortie (exemple une RequestDomainBuilder ramènera un Domain)
 * @param <T3> Type of the identifier
 */
public abstract class AbstractParentRequestBuilder<T1, T2, T3> {
    private Map<String, Object> queryParams;

    private T3 id;

    private T1 childRequester;

    public AbstractParentRequestBuilder(T3 id) {
        this.id = id;
    }

    public abstract List<T2> getAll();

    public void addParams(String keyParam, Object valueParam) {
        if (this.queryParams == null){
            this.queryParams = new HashMap<>();
        }
        this.queryParams.put(keyParam, valueParam);
    }

    public Request build() {
        return new Request();
    }
}
