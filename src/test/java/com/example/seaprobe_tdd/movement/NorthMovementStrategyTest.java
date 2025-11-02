package com.example.seaprobe_tdd.movement;

import com.example.seaprobe_tdd.dto.Coordinate;
import com.example.seaprobe_tdd.enums.DirectionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NorthMovementStrategyTest {
    @Autowired
    private NorthMovementStrategy northMovementStrategy;

    @Test
    void direction() {
        assertEquals(DirectionEnum.N,northMovementStrategy.directionEnum());
    }

    @Test
    void moveForward() {
        Coordinate inputCoordinate = new Coordinate(1,5);
        Coordinate output = northMovementStrategy.getForwardCoordinate(inputCoordinate);

        assertEquals(inputCoordinate.x(), output.x());
        assertEquals(inputCoordinate.y()+1, output.y());
    }

    @Test
    void moveBackward() {
        Coordinate inputCoordinate = new Coordinate(1,5);
        Coordinate output = northMovementStrategy.getBackwardCoordinate(inputCoordinate);
        assertEquals(inputCoordinate.x(), output.x());
        assertEquals(inputCoordinate.y()-1, output.y());

    }
}