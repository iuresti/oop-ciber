package ns.apprentice.oop.ciber.service.impl;

import java.util.Collection;

import ns.apprentice.oop.App;
import ns.apprentice.oop.ciber.model.User;
import ns.apprentice.oop.ciber.repository.UserRepository;
import ns.apprentice.oop.ciber.service.UserService;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = (UserRepository) App.getBean(App.BEAN_USER_REPOSITORY);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public Collection<User> getAll() {
        return userRepository.getAll();
    }


}
