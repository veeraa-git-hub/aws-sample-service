package com.fdc.ddp.sample.awsservice.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({ "com.fdc.ddp.*" })
@EnableAutoConfiguration
public class AwsServiceConfig {

	@Primary
    @Bean
    public ObjectMapper objectMapper() {
    	final ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.registerModule(new JavaTimeModule());
    	objectMapper.registerModule(new JodaModule());
    	objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    	objectMapper.enable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
    	objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	objectMapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    	objectMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
    	objectMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY);
    	return objectMapper;
    }

}
