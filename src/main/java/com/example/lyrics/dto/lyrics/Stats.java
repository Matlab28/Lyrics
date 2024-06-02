package com.example.lyrics.dto.lyrics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Stats {
    @JsonProperty("unreviewed_annotations")
    public Integer unreviewedAnnotations;
    public Boolean hot;
}
