package com.example.seaprobe_tdd.movement;


import com.example.seaprobe_tdd.dto.Coordinate;
import com.example.seaprobe_tdd.enums.DirectionEnum;

public interface IDirectionalMovementStrategy {

    DirectionEnum directionEnum();

    Coordinate getForwardCoordinate(Coordinate input);

    Coordinate getBackwardCoordinate(Coordinate input);
}