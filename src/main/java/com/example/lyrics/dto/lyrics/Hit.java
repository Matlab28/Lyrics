package com.example.lyrics.dto.lyrics;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Hit {
    public ArrayList<Object> highlights;
    public String index;
    public String type;
    public Result result;
}
