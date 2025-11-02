package com.example.seaprobe_tdd.commands;

import com.example.seaprobe_tdd.dto.ProbeRequest;
import com.example.seaprobe_tdd.enums.CommandEnum;

public interface ICommand {
    CommandEnum command();
    void execute(ProbeRequest probeEnvironment);

}
