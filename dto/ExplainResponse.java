package com.mohan.ai_assistant.dto;

import lombok.Data;

@Data
public class ExplainResponse {
    private String summary;
    private String example;
    private String useCases;
}
