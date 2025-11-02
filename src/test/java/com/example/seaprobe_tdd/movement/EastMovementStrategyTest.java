package com.example.seaprobe_tdd.movement;

import com.example.seaprobe_tdd.dto.Coordinate;
import com.example.seaprobe_tdd.enums.DirectionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EastMovementStrategyTest {

    @Autowired
    private EastMovementStrategy eastMovementStrategy;

    @Test
    void direction() {
        assertEquals(DirectionEnum.E, eastMovementStrategy.directionEnum());
    }

    @Test
    void moveForward() {
        Coordinate inputCoordinate = new Coordinate(1,5);
        Coordinate output = eastMovementStrategy.getForwardCoordinate(inputCoordinate);
        assertEquals(inputCoordinate.x()+1, output.x());
        assertEquals(inputCoordinate.y(), output.y());
    }

    @Test
    void moveBackward() {
        Coordinate inputCoordinate = new Coordinate(1,5);
        Coordinate output = eastMovementStrategy.getBackwardCoordinate(inputCoordinate);
        assertEquals(inputCoordinate.x()-1, output.x());
        assertEquals(inputCoordinate.y(), output.y());
    }
}