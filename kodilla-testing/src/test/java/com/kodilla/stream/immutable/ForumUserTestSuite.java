package com.kodilla.stream.immutable;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ForumUserTestSuite {

    @Test
    void testImmutableUser() {
        // Given
        ForumUser user = new ForumUser("john_doe", "John Doe");

        // When
        String username = user.getUsername();
        String realName = user.getRealName();

        // Then
        assertEquals("john_doe", username);
        assertEquals("John Doe", realName);
    }
}
