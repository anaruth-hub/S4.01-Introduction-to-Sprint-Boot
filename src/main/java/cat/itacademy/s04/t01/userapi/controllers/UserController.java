package cat.itacademy.s04.t01.userapi.controllers;

import cat.itacademy.s04.t01.userapi.dto.CreateUserRequest;
import cat.itacademy.s04.t01.userapi.exceptions.UserNotFoundException;
import cat.itacademy.s04.t01.userapi.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final List<User> users = new CopyOnWriteArrayList<>();

    static void clearUsers() {
        users.clear();
    }

    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) String name) {
        if (name == null || name.isBlank()) {
            return users;
        }

        String textToSearch = name.toLowerCase();

        return users.stream()
                .filter(user -> user.name() != null
                        && user.name().toLowerCase().contains(textToSearch))
                .toList();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
        User newUser = new User(
                UUID.randomUUID(),
                request.name(),
                request.email()
        );

        users.add(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) {
        return users.stream()
                .filter(user -> user.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found: " + id));
    }
}