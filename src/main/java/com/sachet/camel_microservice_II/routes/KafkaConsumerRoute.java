package com.sachet.camel_microservice_II.routes;

import com.sachet.camel_microservice_II.utility.LoggingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerRoute extends RouteBuilder {

    private final LoggingProcessor processor;

    public KafkaConsumerRoute(LoggingProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void configure() throws Exception {
        from("kafka:camel-topic")
                .process(processor)
                .log("${body}");
    }
}
