package com.mohan.ai_assistant.controller;

import com.mohan.ai_assistant.application.AIApplicationService;
import com.mohan.ai_assistant.domain.model.PromptType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AIController {

    private final AIApplicationService appService;

    @GetMapping("/process")
    public String process(
            @RequestParam PromptType type,
            @RequestParam String input
    ) {
        return appService.process(type, input);
    }
}
