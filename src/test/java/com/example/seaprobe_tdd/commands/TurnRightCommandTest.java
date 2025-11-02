package com.example.seaprobe_tdd.commands;

import com.example.seaprobe_tdd.dto.Probe;
import com.example.seaprobe_tdd.dto.ProbeRequest;
import com.example.seaprobe_tdd.enums.CommandEnum;
import com.example.seaprobe_tdd.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnRightCommandTest {
    @Autowired
    private TurnRightCommand turnRightCommand;

    @Test
    void command() {
        assertEquals(CommandEnum.TURN_RIGHT, turnRightCommand.commandEnum());
    }

    @Test
    void execute() {
        ProbeRequest probeRequest = Utils.prepareProbeRequest();
        Probe probeBeforeStateUpdate = Utils.deepCopyProbe(probeRequest.getProbe());

        turnRightCommand.execute(probeRequest);
        Probe probeAfterStateUpdate = probeRequest.getProbe();

        assertEquals(probeBeforeStateUpdate.getCurrentCoordinate(), probeAfterStateUpdate.getCurrentCoordinate());
       assertNotEquals(probeBeforeStateUpdate.getCurrentDirection(), probeAfterStateUpdate.getCurrentDirection());
    }
}