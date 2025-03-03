package com.tools.toolbox.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDGenerator {
    public String generateUUID() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(0, 8);
    }
}
