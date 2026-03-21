package cat.itacademy.s04.t01.userapi.repositories;

import cat.itacademy.s04.t01.userapi.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryUserRepositoryTest {

    private InMemoryUserRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryUserRepository();
    }

    @Test
    void findAll_returnsEmptyInitially() {
        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    void save_addsUser() {
        User user = new User(UUID.randomUUID(), "Ana", "ana@example.com");
        repository.save(user);

        assertEquals(1, repository.findAll().size());
    }

    @Test
    void findById_returnsUserIfExists() {
        UUID id = UUID.randomUUID();
        User user = new User(id, "Ana", "ana@example.com");
        repository.save(user);

        assertTrue(repository.findById(id).isPresent());
    }

    @Test
    void searchByName_returnsMatchingUsers() {
        repository.save(new User(UUID.randomUUID(), "Ada Lovelace", "ada@example.com"));
        repository.save(new User(UUID.randomUUID(), "John Smith", "john@example.com"));

        assertEquals(1, repository.searchByName("ada").size());
    }

    @Test
    void existsByEmail_detectsEmailIgnoringCase() {
        repository.save(new User(UUID.randomUUID(), "Ana", "Ana@Example.com"));

        assertTrue(repository.existsByEmail("ana@example.com"));
    }
}