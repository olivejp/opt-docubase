package nc.opt.docubase.domain.builder;

import nc.opt.docubase.domain.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param <T1> Variable de sortie (exemple une RequestDomainBuilder ramènera un Domain)
 * @param <T2> Type of the identifier
 */
public abstract class AbstractRequestBuilder<T1, T2> {
    private Map<String, Object> queryParams;

    private T2 id;

    public AbstractRequestBuilder(T2 id) {
        this.id = id;
    }

    public abstract List<T1> getAll();

    public void addParams(String keyParam, Object valueParam) {
        if (this.queryParams == null) {
            this.queryParams = new HashMap<>();
        }
        this.queryParams.put(keyParam, valueParam);
    }

    public Request build() {
        return new Request();
    }
}
