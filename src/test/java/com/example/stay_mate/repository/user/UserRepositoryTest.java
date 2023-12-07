package com.example.stay_mate.repository.user;

import com.example.stay_mate.model.user.User;
import com.example.stay_mate.repository.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        // Given
        String userEmail = "test@example.com";
        User user = new User();
        user.setEmail(userEmail);
        userRepository.save(user);

        // When
        Optional<User> foundUser = userRepository.findByEmail(userEmail);

        // Then
        assertTrue(foundUser.isPresent());
        assertEquals(userEmail, foundUser.get().getEmail());
    }

    @Test
    public void testExistsByEmail() {
        // Given
        String existingEmail = "existing@example.com";
        User user = new User();
        user.setEmail(existingEmail);
        userRepository.save(user);

        // When
        boolean existsByEmail = userRepository.existsByEmail(existingEmail);
        boolean nonExistingEmail = userRepository.existsByEmail("nonexisting@example.com");

        // Then
        assertTrue(existsByEmail);
        assertFalse(nonExistingEmail);
    }
}


