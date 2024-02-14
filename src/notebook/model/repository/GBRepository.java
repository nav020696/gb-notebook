package notebook.model.repository;

import notebook.model.User;

import java.util.List;
import java.util.Optional;

public interface GBRepository {
    List<User> findAll();
    User create(List<String> usersDates);
    Optional<User> findById(Long id);
    Optional<User> update(Long userId, List<String> usersDates);
    boolean delete(Long id);
}
