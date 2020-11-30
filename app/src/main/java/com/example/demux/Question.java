package com.example.demux;

import java.util.ArrayList;

public class Question {
    public String text;
    public String[] tags;
    public String freq;

    public Question() {
    }

    public Question(String text, String[] tags, String freq) {
        this.text = text;
        this.tags = tags;
        this.freq = freq;
    }
}
