package com.example.seaprobe_tdd.movement;

import com.example.seaprobe_tdd.enums.DirectionEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class MovementStrategyFactory {

    private Map<DirectionEnum, IMovementStrategy> movementStrategy;

    public MovementStrategyFactory(List<IMovementStrategy> movements){
        this.movementStrategy = movements.stream().collect(Collectors.toMap(IMovementStrategy::direction, a -> a));
    }

    public IMovementStrategy getMovementStrategy(DirectionEnum direction) {
        return movementStrategy.get(direction);
    }
}
