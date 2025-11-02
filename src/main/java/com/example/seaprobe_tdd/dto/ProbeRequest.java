package com.example.seaprobe_tdd.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ProbeRequest {
    private Probe probe;
    private Grid grid;
    private Set<Coordinate> obstacles;
}
