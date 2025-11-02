package com.example.seaprobe_tdd.movement;


import com.example.seaprobe_tdd.dto.Coordinate;
import com.example.seaprobe_tdd.enums.DirectionEnum;
import org.springframework.stereotype.Component;

@Component
public class NorthMovementStrategy implements IDirectionalMovementStrategy {
    @Override
    public DirectionEnum directionEnum() {
        return DirectionEnum.N;
    }

    @Override
    public Coordinate getForwardCoordinate(Coordinate input) {
        return new Coordinate(input.x(), input.y() + 1);
    }

    @Override
    public Coordinate getBackwardCoordinate(Coordinate input) {
        return new Coordinate(input.x(), input.y() - 1);
    }
}
