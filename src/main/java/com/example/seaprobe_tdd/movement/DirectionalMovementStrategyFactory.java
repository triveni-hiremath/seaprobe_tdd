package com.example.seaprobe_tdd.movement;

import com.example.seaprobe_tdd.enums.DirectionEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DirectionalMovementStrategyFactory {

    private Map<DirectionEnum, IDirectionalMovementStrategy> movementStrategy;

    public DirectionalMovementStrategyFactory(List<IDirectionalMovementStrategy> movements){
        this.movementStrategy = movements.stream().collect(Collectors.toMap(IDirectionalMovementStrategy::directionEnum, a -> a));
    }

    public IDirectionalMovementStrategy getDirectionalMovementStrategy(DirectionEnum direction) {
        return movementStrategy.get(direction);
    }
}
