package interfaces;

import java.util.List;
import java.util.Optional;

public interface Crud <T,ID>{
    void update(T t);
    void add(T t);
    void deleteById(ID id);
    Optional<T> getById(ID id);
    List<T> listAll();

}
