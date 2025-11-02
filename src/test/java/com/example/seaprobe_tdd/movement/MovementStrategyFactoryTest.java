package com.example.seaprobe_tdd.movement;

import com.example.seaprobe_tdd.enums.DirectionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovementStrategyFactoryTest {

    @Autowired
    private DirectionalMovementStrategyFactory movementStrategyFactory;

    @Autowired
    private List<IDirectionalMovementStrategy> movementStrategies;

    @Test
    void getMovementStrategy() {
        Arrays.stream(DirectionEnum.values()).forEach( directionEnum -> {
                    IDirectionalMovementStrategy strategy = movementStrategyFactory.getDirectionalMovementStrategy(directionEnum);
                    assertEquals(directionEnum, strategy.directionEnum());
                });
    }

    @Test
    void testSizeOfMovementStrategies(){
        assertEquals(DirectionEnum.values().length, movementStrategies.size());
    }
}