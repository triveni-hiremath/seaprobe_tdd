package com.example.seaprobe_tdd.service;

import com.example.seaprobe_tdd.dto.Probe;
import com.example.seaprobe_tdd.dto.ProbeRequestDTO;

public interface IProbeService {
    Probe operateProbe(ProbeRequestDTO request);
}
