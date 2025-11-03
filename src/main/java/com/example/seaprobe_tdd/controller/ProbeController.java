package com.example.seaprobe_tdd.controller;

import com.example.seaprobe_tdd.dto.Probe;
import com.example.seaprobe_tdd.dto.ProbeRequestDTO;
import com.example.seaprobe_tdd.service.IProbeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/probe")
@AllArgsConstructor
public class ProbeController {

    private IProbeService probeService;

    @PostMapping("/operate")
    public ResponseEntity<Probe> operateProbe(@Valid @RequestBody ProbeRequestDTO request){
            return ResponseEntity.ok(probeService.operateProbe(request));
    }
}