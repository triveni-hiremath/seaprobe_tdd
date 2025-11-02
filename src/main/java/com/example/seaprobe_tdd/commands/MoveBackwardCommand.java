package com.example.seaprobe_tdd.commands;

import com.example.seaprobe_tdd.Utils.Validator;
import com.example.seaprobe_tdd.dto.Coordinate;
import com.example.seaprobe_tdd.dto.Probe;
import com.example.seaprobe_tdd.dto.ProbeRequest;
import com.example.seaprobe_tdd.enums.CommandEnum;
import com.example.seaprobe_tdd.movement.IMovementStrategy;
import com.example.seaprobe_tdd.movement.MovementStrategyFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MoveBackwardCommand implements ICommand {

    private MovementStrategyFactory factory;

    @Override
    public CommandEnum command() {
        return CommandEnum.MOVE_BACKWARD;
    }

    @Override
    public void execute(ProbeRequest probeEnvironment) {
        Probe probe = probeEnvironment.getProbe();
        IMovementStrategy strategy = factory.getMovementStrategy(probe.getCurrentDirection());
        Coordinate coordinate = strategy.moveBackward(probe.getCurrentCoordinate());
        if (Validator.validCoordinate(probeEnvironment.getGrid(), coordinate)
        && Validator.notAnObstacle(probeEnvironment.getObstacles(), coordinate)){
            probe.setCurrentCoordinate(coordinate);
        }
    }

}
