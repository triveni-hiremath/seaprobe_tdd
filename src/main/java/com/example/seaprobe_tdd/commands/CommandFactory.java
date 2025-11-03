package com.example.seaprobe_tdd.commands;

import com.example.seaprobe_tdd.enums.CommandEnum;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CommandFactory {

    private Map<CommandEnum, ICommand> commands;

    public CommandFactory(List<ICommand> commands){
        this.commands = commands.stream().collect(Collectors.toMap(ICommand::commandEnum, a -> a));
    }

    public ICommand getCommand(CommandEnum commandEnum) {
        return commands.get(commandEnum);
    }
}
