package com.example.lyrics.client;

import com.example.lyrics.dto.request.RootRequestDto;
import com.example.lyrics.dto.request.TelegramSendDto;
import com.example.lyrics.dto.response.RootResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "telegramApi", url = "https://api.telegram.org/bot6476350207:AAFVjjq6_vBTgNri3aaDgQYEZzV-y-KBNGA")
public interface TelegramClient {
    @GetMapping("/getUpdates?offset={value}")
    RootRequestDto getUpdates(@PathVariable Long value);

    @PostMapping("/sendMessage")
    RootResponseDto sendMessage(@RequestBody TelegramSendDto dto);
}
