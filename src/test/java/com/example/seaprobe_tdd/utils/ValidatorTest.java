package com.example.seaprobe_tdd.utils;

import com.example.seaprobe_tdd.Utils.Validator;
import com.example.seaprobe_tdd.dto.Coordinate;
import com.example.seaprobe_tdd.dto.Grid;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ValidatorTest {

    @Test
    void validCoordinate() {
        Grid grid = new Grid(0,5,0,4);

        Coordinate validCoordinate = new Coordinate(3,2);
        assertTrue(Validator.validCoordinate(grid, validCoordinate));

        Coordinate invalidCoordinate = new Coordinate(6,2);
        assertFalse(Validator.validCoordinate(grid, invalidCoordinate));
    }

    @Test
    void notAnObstacle() {

        Set<Coordinate> obstacles = Set.of(new Coordinate(1,2),
                new Coordinate(4,2),
                new Coordinate(5,2),
                new Coordinate(0,2));

        Coordinate validCoordinate = new Coordinate(3,2);
        assertTrue(Validator.notAnObstacle(obstacles, validCoordinate));

        Coordinate invalidCoordinate = new Coordinate(4,2);
        assertFalse(Validator.notAnObstacle(obstacles, invalidCoordinate));

    }
}