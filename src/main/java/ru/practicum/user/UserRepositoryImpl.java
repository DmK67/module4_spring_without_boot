package ru.practicum.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private List<User> listUsers = new ArrayList<>();
    private long nextIdUser = 0;

    @Override
    public List<User> findAll() {
        return listUsers;
    }

    @Override
    public User save(User user) {
        if (user.getId() != null && user.getId() != 0) {
            listUsers.remove(user.getId());
            listUsers.add(user);
        } else {
            user.setId(nextIdUser++);
            listUsers.add(user);
        }
        return user;
    }
}
