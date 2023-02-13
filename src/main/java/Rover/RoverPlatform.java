package Rover;

import LunarControl.CoOrds;
import LunarControl.MoveOrientation;
import Maps.Grid;
import Maps.SimpleGrid;

import java.util.ArrayList;

public class RoverPlatform extends SimpleRoverImpl{

    public RoverPlatform(){

    }
    public RoverPlatform(RoverPlatform roverPlatform){
        this.roverName = roverPlatform.getName();
        this.roverId = roverPlatform.getId();
        this.currentMap = roverPlatform.getCurrentMap();
        this.startPosition = roverPlatform.getStartPosition();
        this.currentPosition = roverPlatform.getCurrentRoverPosition();
        this.currentOrientation = roverPlatform.getCurrentOrientation();
    }

}
