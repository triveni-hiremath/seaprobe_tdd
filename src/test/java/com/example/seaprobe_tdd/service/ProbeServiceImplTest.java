package com.example.seaprobe_tdd.service;

import com.example.seaprobe_tdd.dto.Probe;
import com.example.seaprobe_tdd.dto.ProbeRequestDTO;
import com.example.seaprobe_tdd.utils.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProbeServiceImplTest {

    @Autowired
    private ProbeServiceImpl probeService;

    @Test
    void testObstacles() {
        ProbeRequestDTO request = Utils.convertJsonToObject("static/service/operate-probes-obstacle-check-request.json",
                ProbeRequestDTO.class);
        Probe result = probeService.operateProbe(request);
        Probe expected = Utils.convertJsonToObject("static/service/operate-probes-obstacle-check-response.json",
                Probe.class);
        Utils.compareProbes(expected, result);
    }

    @Test
    void testOutOfGrid() {
        ProbeRequestDTO request = Utils.convertJsonToObject("static/service/operate-probes-obstacle-check-request.json",
                ProbeRequestDTO.class);
        Probe result = probeService.operateProbe(request);
        Probe expected = Utils.convertJsonToObject("static/service/operate-probes-obstacle-check-response.json",
                Probe.class);
        Utils.compareProbes(expected, result);
    }


}