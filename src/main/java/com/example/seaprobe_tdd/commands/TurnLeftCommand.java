package com.example.seaprobe_tdd.commands;

import com.example.seaprobe_tdd.dto.ProbeRequest;
import com.example.seaprobe_tdd.enums.CommandEnum;
import com.example.seaprobe_tdd.enums.DirectionEnum;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Component
public class TurnLeftCommand implements ICommand {
    @Override
    public CommandEnum commandEnum() {
        return CommandEnum.TURN_LEFT;
    }

    @Override
    public void execute(ProbeRequest probeEnvironment) {
        DirectionEnum direction = turnLeft(probeEnvironment.getProbe().getCurrentDirection());
        probeEnvironment.getProbe().setCurrentDirection(direction);
    }

    private DirectionEnum turnLeft(DirectionEnum currentDirection){
        return switch (currentDirection) {
            case N -> DirectionEnum.W;
            case W -> DirectionEnum.S;
            case S -> DirectionEnum.E;
            case E -> DirectionEnum.N;
        };
    }
}
