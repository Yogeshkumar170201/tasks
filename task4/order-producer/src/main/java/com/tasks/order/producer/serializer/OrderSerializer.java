package com.tasks.order.producer.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tasks.order.producer.dto.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.io.IOException;

/**
 * Convert Order Json Object into Json String
 */
public class OrderSerializer extends JsonSerializer<Order> {
    /**
     * @param order         Value to serialize; can <b>not</b> be null.
     * @param jsonGenerator Generator used to output resulting Json content
     * @param serializers   Provider that can be used to get serializers for
     *                      serializing Objects value contains, if any.
     * @throws IOException
     */
    @Override
    @ExceptionHandler(value = IOException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public void serialize(Order order, JsonGenerator jsonGenerator, SerializerProvider serializers) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonGenerator.writeObject(order);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
