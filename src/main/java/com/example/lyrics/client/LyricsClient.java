package com.example.lyrics.client;

import com.example.lyrics.dto.lyrics.Root;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class LyricsClient {
    private final WebClient webClient;

    @Value("YOUR_API_HOST")
    private String apiHost;

    @Value("YOUR_API_KEY")
    private String apiKey;

    public LyricsClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://genius-song-lyrics1.p.rapidapi.com").build();
    }

    public Root getData(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/search").queryParam("q", query).build())
                .header("X-RapidAPI-Host", apiHost)
                .header("X-RapidAPI-Key", apiKey)
                .retrieve()
                .bodyToMono(Root.class)
                .block();
    }
}
