package com.mohan.ai_assistant.infrastructure.llm;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@ConfigurationProperties(prefix = "ollama")
@Data
public class OllamaConfig {
    private String baseUrl;
    private String model;
    private Duration timeout;
}
