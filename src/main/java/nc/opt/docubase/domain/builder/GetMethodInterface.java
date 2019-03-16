package nc.opt.docubase.domain.builder;

import java.util.List;

/**
 * @param <T> type of the identifier
 * @param <S> type of the object returned
 */
public interface GetMethodInterface<T, S> {
    S get(T idToGet);

    List<S> getAll();
}

