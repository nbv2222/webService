package ru.tinkoff.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {
    private JsonHelper() {
    }

    public static <E> String convert(E object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
           return exceptionJson(e);
        }
    }

    public static String exceptionJson(Exception e) {
        return String.format("{\"Exception\" : \"%s\", \"message\" : \"%s\" }", e.getClass().toString(), e.getLocalizedMessage());
    }
}
