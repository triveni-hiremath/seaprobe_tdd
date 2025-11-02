package com.example.seaprobe_tdd.commands;

import com.example.seaprobe_tdd.dto.ProbeRequest;
import com.example.seaprobe_tdd.enums.CommandEnum;
import com.example.seaprobe_tdd.enums.DirectionEnum;
import org.springframework.stereotype.Component;

@Component
public class TurnRightCommand implements ICommand {
    @Override
    public CommandEnum commandEnum() {
        return CommandEnum.TURN_RIGHT;
    }

    @Override
    public void execute(ProbeRequest probeEnvironment) {
        DirectionEnum direction = turnRight(probeEnvironment.getProbe().getCurrentDirection());
        probeEnvironment.getProbe().setCurrentDirection(direction);
    }

    private DirectionEnum turnRight(DirectionEnum currentDirection){
        return switch (currentDirection) {
            case N -> DirectionEnum.E;
            case E -> DirectionEnum.S;
            case S -> DirectionEnum.W;
            case W -> DirectionEnum.N;
            default -> throw new RuntimeException("Unknown Direction");
        };
    }
}
