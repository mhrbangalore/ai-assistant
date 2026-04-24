package com.mohan.ai_assistant.dto;

import com.mohan.ai_assistant.domain.model.PromptType;
import lombok.Data;

@Data
public class AIRequestDto {
    private PromptType type;
    private String input;
}
