package com.eventdriver.consumer.queueBroker.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageBrokerConfig {
    @Value("${rabbitmq.queue.name}")
    private String queueJson;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeJson;

    @Value("${rabbitmq.routing.key}")
    private String routingKeyJson;


    @Bean
    public Queue queueJson() {
        return new Queue(queueJson);
    }

    @Bean
    public TopicExchange exchangeJson() {
        return new TopicExchange(exchangeJson);
    }

    @Bean
    public Binding bindingJson() {
        return BindingBuilder
                .bind(queueJson())
                .to(exchangeJson())
                .with(routingKeyJson);
    }


    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrentConsumers(5);
        factory.setMaxConcurrentConsumers(5);
        factory.setPrefetchCount(1);
        return factory;
    }
}
