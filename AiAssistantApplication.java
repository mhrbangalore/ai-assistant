package com.mohan.ai_assistant;

import com.mohan.ai_assistant.infrastructure.llm.OllamaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class AiAssistantApplication {

	static void main(String[] args) {
		SpringApplication.run(AiAssistantApplication.class, args);
	}

}
