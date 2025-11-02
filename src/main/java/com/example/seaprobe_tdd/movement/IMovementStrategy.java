package com.example.seaprobe_tdd.movement;


import com.example.seaprobe_tdd.dto.Coordinate;
import com.example.seaprobe_tdd.enums.DirectionEnum;

public interface IMovementStrategy {

    DirectionEnum direction();

    Coordinate moveForward(Coordinate input);

    Coordinate moveBackward(Coordinate input);
}