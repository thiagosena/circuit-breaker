package com.thiagosena.product.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerLogConfig {
    private final Logger log = LoggerFactory.getLogger(CircuitBreakerLogConfig.class);

    @Bean
    public RegistryEventConsumer<CircuitBreaker> cbLog() {
        return new RegistryEventConsumer<>() {
            @Override
            public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
                entryAddedEvent.getAddedEntry()
                        .getEventPublisher()
                        .onStateTransition(event -> log.info(event.toString()));
            }

            @Override
            public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {
                entryRemoveEvent.getRemovedEntry()
                        .getEventPublisher()
                        .onStateTransition(event -> log.info(event.toString()));
            }

            @Override
            public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {
                entryReplacedEvent.getNewEntry()
                        .getEventPublisher()
                        .onStateTransition(event -> log.info("new event: {}", event));
                entryReplacedEvent.getOldEntry()
                        .getEventPublisher()
                        .onStateTransition(event -> log.info("old event: {}", event));
            }
        };
    }
}
