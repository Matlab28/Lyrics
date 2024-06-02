package com.example.lyrics.dto.lyrics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PrimaryArtist {
    @JsonProperty("_type")
    public String type;
    @JsonProperty("api_path")
    public String apiPath;
    @JsonProperty("header_image_url")
    public String headerImageUrl;
    public Integer id;
    @JsonProperty("image_url")
    public String imageUrl;
    @JsonProperty("index_character")
    public String indexCharacter;
    @JsonProperty("is_meme_verified")
    public Boolean isMemeVerified;
    @JsonProperty("is_verified")
    public Boolean isVerified;
    public String name;
    public String slug;
    public String url;
    public Integer iq;
}
