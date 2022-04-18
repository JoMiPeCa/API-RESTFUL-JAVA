package com.ey.users.utilities;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ResponseHandlerTest {

    private static final String DEFAULT_TEXT = "default";

    @Test
    void generateResponse() {
        ResponseEntity<Object> result = ResponseHandler.generateResponse(DEFAULT_TEXT, HttpStatus.GONE, DEFAULT_TEXT);
        assertEquals(HttpStatus.GONE, result.getStatusCode());

    }

    @Test
    void generateResponse204() {
        ResponseEntity<Object> result = ResponseHandler.generateResponse(DEFAULT_TEXT, HttpStatus.NO_CONTENT, DEFAULT_TEXT);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }


}