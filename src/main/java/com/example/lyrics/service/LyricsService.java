package com.example.lyrics.service;

import com.example.lyrics.client.LyricsClient;
import com.example.lyrics.client.TelegramClient;
import com.example.lyrics.dto.lyrics.Root;
import com.example.lyrics.dto.request.RootRequestDto;
import com.example.lyrics.dto.request.TelegramSendDto;
import com.example.lyrics.dto.response.RootResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LyricsService {
    private final TelegramClient telegramClient;
    private final LyricsClient lyricsClient;
    private Long lastUpdateId = 0L;

    public RootRequestDto getUpdateService() {
        RootRequestDto updates = telegramClient.getUpdates(0L);
        Integer updateId = updates.getResult().get(updates.getResult().size() - 1).getUpdateId();
        log.info("Message got from - " + updates.getResult().get(0).getMessage().getFrom().getFirstName());
        return telegramClient.getUpdates(Long.valueOf(updateId));
    }

    public Root getLyrics(String query) {
        return lyricsClient.getData(query);
    }

    public RootResponseDto sendMessage(TelegramSendDto dto) {
        return telegramClient.sendMessage(dto);
    }

    public RootResponseDto sendResponse() {
        RootRequestDto updateService = getUpdateService();
        String text = updateService.getResult().get(0).getMessage().getText();
        Long id = updateService.getResult().get(0).getMessage().getChat().getId();
        TelegramSendDto dto = new TelegramSendDto();
        dto.setChatId(String.valueOf(id));

        if (text.equals("/start")) {
            String msg = "Hi " + updateService.getResult().get(0).getMessage().getFrom().getFirstName() +
                    ", welcome to Lyrics bot!\n\nHow can I help you?";

            dto.setText(msg);
            sendMessage(dto);
        } else {
            Root lyricsData = getLyrics(text);
            if (lyricsData != null && !lyricsData.getHits().isEmpty()) {
                StringBuilder message = new StringBuilder();
                lyricsData.getHits().forEach(hit -> {
                    message.append("Title: ").append(hit.getResult().getFullTitle()).append("\n")
                            .append("Artist: ").append(hit.getResult().getPrimaryArtist().getName()).append("\n")
                            .append("URL: ").append(hit.getResult().getUrl()).append("\n\n");
                });
                dto.setText(message.toString());
            } else {
                log.error("Sorry, no lyrics found for your query.");
                dto.setText("Sorry, no lyrics found for your query.");
            }
            return sendMessage(dto);
        }

        return sendMessage(dto);
    }

    @Scheduled(fixedDelay = 1000)
    public void refresh() {
        RootRequestDto updateService = getUpdateService();
        if (!updateService.getResult().isEmpty()) {
            Integer latestUpdateId = updateService.getResult().get(updateService.getResult().size() - 1).getUpdateId();
            if (latestUpdateId > lastUpdateId) {
                lastUpdateId = Long.valueOf(latestUpdateId);
                sendResponse();
            }
        }
    }
}
