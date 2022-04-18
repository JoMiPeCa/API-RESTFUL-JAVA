package com.ey.users.domain;

import com.ey.users.utilities.Helper;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SessionDataTest extends Helper {

    private SessionData sessionData = new SessionData("test@test.net");

    @Test
    void setId() {
        UUID id = UUID.randomUUID();
        sessionData.setId(id);
        assertEquals(id,sessionData.getId());
    }

    @Test
    void getDateModified() {
        assertInstanceOf(Date.class, sessionData.getDateModified());
    }

    @Test
    void getLastLogin() {
        assertEquals(sessionData.getDateCreated(), sessionData.getLastLogin());
    }

    @Test
    void getToken() {
        String token = getJWTToken("new@email.org");
        sessionData.setToken(token);
        assertEquals(token,sessionData.getToken());
    }

    @Test
    void isIsactive() {
        assertTrue(sessionData.isIsactive());
    }

}