package com.soturit.springaiollama;

import java.util.Map;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final OllamaChatModel chatModel;

    @Autowired
    public ChatController(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @GetMapping(path = "/ai/generate", produces = "text/html")
    public String generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return "<pre>" + this.chatModel.call(message) + "</pre>";
    }

}