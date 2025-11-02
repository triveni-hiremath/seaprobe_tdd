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
class MoveBackwardCommandTest {

    @Autowired
    private MoveBackwardCommand moveBackwardCommand;

    @Test
    void command() {
        assertEquals(CommandEnum.MOVE_BACKWARD, moveBackwardCommand.commandEnum());
    }

    @Test
    void execute() {
       ProbeRequest probeRequest = Utils.prepareProbeRequest();
       Probe probeBeforeStateUpdate = Utils.deepCopyProbe(probeRequest.getProbe());

       moveBackwardCommand.execute(probeRequest);

       Probe probeAfterStateUpdate = probeRequest.getProbe();
       assertNotEquals(probeBeforeStateUpdate.getCurrentCoordinate(), probeAfterStateUpdate.getCurrentCoordinate());
       assertEquals(probeBeforeStateUpdate.getCurrentDirection(), probeAfterStateUpdate.getCurrentDirection());

        assertEquals(probeBeforeStateUpdate.getCurrentCoordinate().x(), probeAfterStateUpdate.getCurrentCoordinate().x());
        assertEquals(probeBeforeStateUpdate.getCurrentCoordinate().y()-1, probeAfterStateUpdate.getCurrentCoordinate().y());

    }
}