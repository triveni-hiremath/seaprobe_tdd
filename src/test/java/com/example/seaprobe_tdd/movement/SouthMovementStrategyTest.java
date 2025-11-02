package com.example.seaprobe_tdd.movement;

import com.example.seaprobe_tdd.dto.Coordinate;
import com.example.seaprobe_tdd.enums.DirectionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SouthMovementStrategyTest {
    @Autowired
    private SouthMovementStrategy southMovementStrategy;

    @Test
    void direction() {
        assertEquals(DirectionEnum.S,southMovementStrategy.direction());
    }

    @Test
    void moveForward() {
        Coordinate inputCoordinate = new Coordinate(1,5);
        Coordinate output = southMovementStrategy.moveForward(inputCoordinate);

        assertEquals(inputCoordinate.x(), output.x());
        assertEquals(inputCoordinate.y()-1, output.y());
    }

    @Test
    void moveBackward() {
        Coordinate inputCoordinate = new Coordinate(1,5);
        Coordinate output = southMovementStrategy.moveBackward(inputCoordinate);
        assertEquals(inputCoordinate.x(), output.x());
        assertEquals(inputCoordinate.y()+1, output.y());

    }
}
