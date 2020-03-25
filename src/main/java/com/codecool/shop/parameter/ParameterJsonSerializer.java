package com.codecool.shop.parameter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ParameterJsonSerializer extends JsonSerializer<ParameterValue> {
    @Override
    public void serialize(ParameterValue parameterValue,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("type", parameterValue.getType().getName());
        jsonGenerator.writeStringField("value", parameterValue.getParameterValue());
        jsonGenerator.writeEndObject();
    }
}
