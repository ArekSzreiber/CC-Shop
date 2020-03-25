package com.codecool.shop.parameter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JsonTest
@RunWith(SpringRunner.class)
class ParameterJsonSerializerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerialization() throws JsonProcessingException {
        ParameterValue parameterValue = new ParameterValue(new ParameterType("diameter"), "26");
        String json = objectMapper.writeValueAsString(parameterValue);

        assertEquals("{\"type\":\"diameter\",\"value\":\"26\"}", json);
    }
}
