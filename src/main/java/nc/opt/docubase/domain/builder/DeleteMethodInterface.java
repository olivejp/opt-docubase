package nc.opt.docubase.domain.builder;

/**
 * @param <T> Type of the identifier
 */
public interface DeleteMethodInterface<T> {
    T put(T idToDelete);
}