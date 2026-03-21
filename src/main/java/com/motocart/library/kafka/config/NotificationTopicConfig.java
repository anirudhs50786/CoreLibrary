package com.motocart.library.kafka.config;

import com.motocart.library.kafka.KafkaTopics;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@ConditionalOnProperty(name = "moto-cart.kafka.notification.enabled", havingValue = "true")
public class NotificationTopicConfig {

    @Bean
    public NewTopic auditLogEvent() {
        return TopicBuilder.name(KafkaTopics.NOTIFICATION_EVENTS)
                .replicas(1)
                .partitions(1)
                .config(TopicConfig.RETENTION_MS_CONFIG, "86400000")
                .build();
    }
}
