package ns.apprentice.oop.ciber.service;

import java.util.Collection;

import ns.apprentice.oop.ciber.model.User;

public interface UserService {

    void save(User user);

    void delete(User user);

    Collection<User> getAll();
}
