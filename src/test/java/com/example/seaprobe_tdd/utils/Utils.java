package com.example.seaprobe_tdd.utils;

import com.example.seaprobe_tdd.dto.Coordinate;
import com.example.seaprobe_tdd.dto.Grid;
import com.example.seaprobe_tdd.dto.Probe;
import com.example.seaprobe_tdd.dto.ProbeRequest;
import com.example.seaprobe_tdd.enums.DirectionEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Utils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convertJsonToObject(String fileName, Class<T> clazz) {
        try (InputStream is = Utils.class.getClassLoader().getResourceAsStream(fileName)) {
            return objectMapper.readValue(is, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ProbeRequest prepareProbeRequest(){
        Coordinate inputCurrentCoordinate = new Coordinate(3,2);
        Grid grid = new Grid(0,5, 0, 4);

        Probe probe = new Probe();
        probe.setCurrentCoordinate(inputCurrentCoordinate);
        probe.setCurrentDirection(DirectionEnum.N);

        Set<Coordinate> obstacles = Set.of(new Coordinate(1,2),
                new Coordinate(4,2),
                new Coordinate(5,2),
                new Coordinate(0,2));

        return ProbeRequest.builder().probe(probe).grid(grid).obstacles(obstacles).build();
    }

    public static Probe deepCopyProbe(Probe input){
        Probe output = new Probe();
        output.setCurrentDirection(input.getCurrentDirection());
        output.setCurrentCoordinate(input.getCurrentCoordinate());
        return output;
    }

    public static void compareProbes(Probe expected, Probe actual) {
        assertEquals(expected.getCurrentDirection(), actual.getCurrentDirection());
        assertEquals(expected.getCurrentCoordinate(), actual.getCurrentCoordinate());
        assertEquals(expected.getNavigationHistory().size(), actual.getNavigationHistory().size());
        for (int i = 0; i < expected.getNavigationHistory().size(); i++) {
            assertEquals(expected.getNavigationHistory().get(i), actual.getNavigationHistory().get(i));
        }
    }
}