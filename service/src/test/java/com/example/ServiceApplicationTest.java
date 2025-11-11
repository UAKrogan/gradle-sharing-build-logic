package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ServiceApplicationTest {

    @Test
    void shouldRunSpringApplicationWhenMainIsCalled() {
        Assertions.assertDoesNotThrow(() -> ServiceApplication.main(new String[] {}));
    }
}