package com.example.seaprobe_tdd.dto;

import com.example.seaprobe_tdd.enums.CommandEnum;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ProbeRequestDTO {

    private int startX;
    private int startY;
    private int widthX;
    private int heightY;

    private Probe probe;
    private Set<Coordinate> obstacles;
    private List<CommandEnum> commands;
}
