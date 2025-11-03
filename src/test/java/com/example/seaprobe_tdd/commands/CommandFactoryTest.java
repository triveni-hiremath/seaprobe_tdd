package com.example.seaprobe_tdd.commands;

import com.example.seaprobe_tdd.enums.CommandEnum;
import com.example.seaprobe_tdd.enums.DirectionEnum;
import com.example.seaprobe_tdd.movement.DirectionalMovementStrategyFactory;
import com.example.seaprobe_tdd.movement.IDirectionalMovementStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommandFactoryTest {


    @Autowired
    private CommandFactory commandFactory;

    @Autowired
    private List<ICommand> commands;

    @Test
    void getCommand() {
        Arrays.stream(CommandEnum.values()).forEach(commandEnum -> {
            ICommand command = commandFactory.getCommand(commandEnum);
            assertEquals(commandEnum, command.commandEnum());
        });
    }

    @Test
    void testSizeOfCommands(){
        assertEquals(CommandEnum.values().length, commands.size());
    }
}