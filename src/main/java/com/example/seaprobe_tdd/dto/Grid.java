package com.example.seaprobe_tdd.dto;

public record Grid(int x1, int x2, int y1, int y2) {

    public Grid{
        if(x1>=x2) throw new IllegalArgumentException();
        if(y1>=y2) throw new IllegalArgumentException();
    }
}
