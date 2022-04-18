package com.ey.users.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus codeStatus, Object responseObject) {
        Map<String, Object> map = new HashMap<>();
            map.put("message", message);
            map.put("status", codeStatus.value());
            map.put("data", responseObject);
            if (codeStatus.value() == 204)
                codeStatus=HttpStatus.OK;
        return new ResponseEntity<Object>(map,codeStatus);
    }
}
