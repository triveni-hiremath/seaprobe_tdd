package com.example.seaprobe_tdd.commands;


import com.example.seaprobe_tdd.Utils.Validator;
import com.example.seaprobe_tdd.dto.Coordinate;
import com.example.seaprobe_tdd.dto.Probe;
import com.example.seaprobe_tdd.dto.ProbeRequest;
import com.example.seaprobe_tdd.enums.CommandEnum;
import com.example.seaprobe_tdd.movement.IDirectionalMovementStrategy;
import com.example.seaprobe_tdd.movement.DirectionalMovementStrategyFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MoveForwardCommand implements ICommand {

    private DirectionalMovementStrategyFactory factory;

    @Override
    public CommandEnum commandEnum() {
        return CommandEnum.MOVE_FORWARD;
    }

    @Override
    public void execute(ProbeRequest probeEnvironment) {
        Probe probe= probeEnvironment.getProbe();
        IDirectionalMovementStrategy strategy = factory.getDirectionalMovementStrategy(probe.getCurrentDirection());
        Coordinate coordinate = strategy.getForwardCoordinate(probe.getCurrentCoordinate());
        if (Validator.validCoordinate(probeEnvironment.getGrid(), coordinate)
        && Validator.notAnObstacle(probeEnvironment.getObstacles(), coordinate)){
            probe.setCurrentCoordinate(coordinate);
        }
    }
}