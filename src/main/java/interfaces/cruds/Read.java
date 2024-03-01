package interfaces.cruds;

import java.util.List;
import java.util.Optional;

public interface Read<T, ID> {
    Optional<T> getById(ID id);

    List<T> listAll();
}
