package br.com.banking.domain.slip.model;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class SlipDeserializer extends ObjectMapperDeserializer<Slip> {
    public SlipDeserializer(){
        super(Slip.class);
    }
}