package com.sede.electronica.security.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseJwt {

    public static ResponseEntity<Object> generateResponseJwt(String message, HttpStatus status, Object responseObj, String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        map.put("token", token);

        return new ResponseEntity<Object>(map,status);
    }
}
