package cat.itacademy.s04.t01.userapi.services;

import cat.itacademy.s04.t01.userapi.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<User> getUsers(String name);

    User createUser(String name, String email);

    User getUserById(UUID id);
}