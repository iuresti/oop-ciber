package ns.apprentice.oop.ciber.repository.impl;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import ns.apprentice.oop.ciber.model.User;
import ns.apprentice.oop.ciber.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    private HashMap<String, User> users;

    public UserRepositoryImpl() {
        users = new HashMap<>();

        User user;

        user = new User();
        user.setFullName("Juan Pérez");
        user.setId(UUID.randomUUID().toString());
        user.setRegisterDate(LocalDate.now());
        users.put(user.getId(), user);

        user = new User();
        user.setFullName("María Sánchez");
        user.setId(UUID.randomUUID().toString());
        user.setRegisterDate(LocalDate.now());
        users.put(user.getId(), user);
    }

    @Override
    public void save(User user) {

        if (user.getId() == null) {
            user.setId(UUID.randomUUID().toString());
        }

        users.put(user.getId(), user);
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }

    @Override
    public Collection<User> getAll() {
        return users.values();
    }
}
