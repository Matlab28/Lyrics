package com.example.lyrics.dto.lyrics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Result {
    @JsonProperty("_type")
    public String type;
    @JsonProperty("annotation_count")
    public Integer annotationCount;
    @JsonProperty("api_path")
    public String apiPath;
    @JsonProperty("artist_names")
    public String artistNames;
    @JsonProperty("full_title")
    public String fullTitle;
    @JsonProperty("header_image_thumbnail_url")
    public String headerImageThumbnailUrl;
    @JsonProperty("header_image_url")
    public String headerImageUrl;
    public Integer id;
    public Boolean instrumental;
    @JsonProperty("lyrics_owner_id")
    public Integer lyricsOwnerId;
    @JsonProperty("lyrics_state")
    public String lyricsState;
    @JsonProperty("lyrics_updated_at")
    public Integer lyricsUpdatedAt;
    public String path;
    @JsonProperty("pyongs_count")
    public Object pyongsCount;
    @JsonProperty("relationships_index_url")
    public String relationshipsIndexUrl;
    @JsonProperty("release_date_components")
    public ReleaseDateComponents releaseDateComponents;
    @JsonProperty("release_date_for_display")
    public String releaseDateForDisplay;
    @JsonProperty("release_date_with_abbreviated_month_for_display")
    public String releaseDateWithAbbreviatedMonthForDisplay;
    @JsonProperty("song_art_image_thumbnail_url")
    public String songArtImageThumbnailUrl;
    @JsonProperty("songArtImageUrl")
    public String song_art_image_url;
    public Stats stats;
    public String title;
    @JsonProperty("title_with_featured")
    public String titleWithFeatured;
    @JsonProperty("updated_by_human_at")
    public Integer updatedByHumanAt;
    public String url;
    @JsonProperty("featured_artists")
    public ArrayList<Object> featuredArtists;
    @JsonProperty("primary_artist")
    public PrimaryArtist primaryArtist;
    @JsonProperty("primary_artists")
    public ArrayList<PrimaryArtist> primaryArtists;
}
