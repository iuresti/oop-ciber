package ns.apprentice.oop.ciber.repository;

import java.util.Collection;

import ns.apprentice.oop.ciber.model.User;

public interface UserRepository {

    void save(User user);

    void delete(User user);

    Collection<User> getAll();
}
