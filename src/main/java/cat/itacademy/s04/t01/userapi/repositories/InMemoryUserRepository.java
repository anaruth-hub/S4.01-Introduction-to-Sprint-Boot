package cat.itacademy.s04.t01.userapi.repositories;

import cat.itacademy.s04.t01.userapi.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return users.stream()
                .filter(user -> user.id().equals(id))
                .findFirst();
    }

    @Override
    public List<User> searchByName(String name) {
        String textToSearch = name.toLowerCase();

        return users.stream()
                .filter(user -> user.name() != null &&
                        user.name().toLowerCase().contains(textToSearch))
                .toList();
    }

    @Override
    public boolean existsByEmail(String email) {
        return users.stream()
                .anyMatch(user -> user.email() != null &&
                        user.email().equalsIgnoreCase(email));
    }

    @Override
    public void deleteAll() {
        users.clear();
    }
}