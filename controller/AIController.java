package com.mohan.ai_assistant.controller;

import com.mohan.ai_assistant.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AIController {

    private final AIService service;

    @GetMapping("/explain")
    public String explain(@RequestParam String topic) {
        return service.explainConcept(topic);
    }

    @GetMapping("/structured")
    public String structured(@RequestParam String topic) {
        return service.structuredConcept(topic);
    }

    @GetMapping("/code-review")
    public String codeReview(@RequestParam String topic) {
        return service.codeReviewPrompt(topic);
    }

}
