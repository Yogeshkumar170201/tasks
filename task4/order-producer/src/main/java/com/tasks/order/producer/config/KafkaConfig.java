package com.tasks.order.producer.config;

import com.tasks.order.producer.constants.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Produce new topics
 */
@Configuration
public class KafkaConfig {

    /**
     * @return A new topic
     */
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(AppConstants.TOPIC_NAME).build();
    }

}
