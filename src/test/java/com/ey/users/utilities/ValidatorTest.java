package com.ey.users.utilities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void isValidPassword() {
        String fakePassword = "Fakepassword12";
        assertTrue(Validator.isValidPassword(fakePassword));
    }

    @Test
    void isValidEmail() {
        String fakeEmail = "fake@email.com";
        assertTrue(Validator.isValidEmail(fakeEmail));
    }

    @Test
    void isWrongPassword() {
        String fakePassword = "F4k3P4ssw0rd12";
        assertTrue(!Validator.isValidPassword(fakePassword));
    }

    @Test
    void isWrongEmail() {
        String fakeEmail = ".fake.@.email,com";
        assertTrue(!Validator.isValidEmail(fakeEmail));
    }

}