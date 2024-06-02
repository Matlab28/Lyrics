package com.example.lyrics.controller;

import com.example.lyrics.dto.response.RootResponseDto;
import com.example.lyrics.service.LyricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lyrics")
public class LyricsController {
    private final LyricsService service;

    @GetMapping
    public RootResponseDto msgResponse() {
        return service.sendResponse();
    }
}
