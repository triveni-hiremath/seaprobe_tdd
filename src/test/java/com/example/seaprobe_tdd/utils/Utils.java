package com.example.seaprobe_tdd.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convertJsonToObject(String fileName, Class<T> clazz) {
        try (InputStream is = Utils.class.getClassLoader().getResourceAsStream(fileName)) {
            return objectMapper.readValue(is, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
