package com.example.seaprobe_tdd.Utils;

import com.example.seaprobe_tdd.dto.Coordinate;
import com.example.seaprobe_tdd.dto.Grid;

import java.util.Set;

public class Validator {

    public static boolean validCoordinate(Grid grid, Coordinate cord){
        return cord.x() >= grid.x1() && cord.x() <= grid.x2() &&
                cord.y() >= grid.y1() && cord.y() <= grid.y2();
    }

    public static boolean notAnObstacle(Set<Coordinate> obstacles, Coordinate cord){
        return !obstacles.contains(cord);
    }
}
