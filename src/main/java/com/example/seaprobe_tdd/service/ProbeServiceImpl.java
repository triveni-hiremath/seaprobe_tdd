package com.example.seaprobe_tdd.service;

import com.example.seaprobe_tdd.Utils.Validator;
import com.example.seaprobe_tdd.commands.CommandFactory;
import com.example.seaprobe_tdd.dto.Grid;
import com.example.seaprobe_tdd.dto.Probe;
import com.example.seaprobe_tdd.dto.ProbeRequest;
import com.example.seaprobe_tdd.dto.ProbeRequestDTO;
import com.example.seaprobe_tdd.exception.ProbeValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProbeServiceImpl implements IProbeService{

    private CommandFactory commandFactory;

    @Override
    public Probe operateProbe(ProbeRequestDTO request) {
        Grid grid = new Grid(request.getStartX(), request.getStartX() + request.getWidthX(),
                request.getStartY(), request.getStartY()+ request.getHeightY());

        if(!Validator.validCoordinate(grid, request.getProbe().getCurrentCoordinate())){
            throw new ProbeValidationException("Invalid Request, Probe cannot be outside of the grid");
        }
        if (!Validator.notAnObstacle(request.getObstacles(), request.getProbe().getCurrentCoordinate())) {
            throw new ProbeValidationException("Invalid Request, Probe cannot be on obstacle");
        }

        request.getProbe().getNavigationHistory().add(request.getProbe().getCurrentCoordinate());
        ProbeRequest pe = ProbeRequest.builder()
                .probe(request.getProbe())
                .grid(grid)
                .obstacles(request.getObstacles()).build();

        request.getCommands().forEach(commandEnum ->
                commandFactory.getCommand(commandEnum).execute(pe));

        return pe.getProbe();
    }
}