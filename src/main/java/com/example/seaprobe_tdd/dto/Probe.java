package com.example.seaprobe_tdd.dto;

import com.example.seaprobe_tdd.enums.DirectionEnum;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class Probe {

    private Coordinate currentCoordinate;

    private DirectionEnum currentDirection;

    private List<Coordinate> navigationHistory = new ArrayList<>();

    public void setCurrentCoordinate(Coordinate currentCoordinate){
        this.currentCoordinate = currentCoordinate;
        this.navigationHistory.add(currentCoordinate);
    }

}
