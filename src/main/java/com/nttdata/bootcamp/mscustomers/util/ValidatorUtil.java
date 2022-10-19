package com.nttdata.bootcamp.mscustomers.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public class ValidatorUtil {
    public static ResponseEntity<?> validate(BindingResult result) {
        Map<String, String> errors = new HashMap<String, String>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(),
                    String.format("El campo %s: %s", err.getField(), err.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
