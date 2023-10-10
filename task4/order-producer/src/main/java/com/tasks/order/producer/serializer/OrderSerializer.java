package com.tasks.order.producer.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.tasks.order.producer.dto.Order;


import java.io.IOException;

public class OrderSerializer extends JsonSerializer<Order> {
    @Override
    public void serialize(Order order, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        jsonGenerator.writeObject(order);
    }
}
