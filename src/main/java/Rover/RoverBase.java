package Rover;

import LunarControl.CoOrds;
import LunarControl.MoveOrientation;
import Maps.SimpleGrid;

public interface RoverBase {
    boolean initialiseRover(String name, String id, SimpleGrid map,
                            CoOrds initialPosition, MoveOrientation initialOrientation);
    boolean setMap(SimpleGrid map);
    boolean makeMove(MoveOrientation nextMove);
    private void logMove(MoveOrientation justMoved) {}

    SimpleGrid getCurrentMap();
    CoOrds getCurrentRoverPosition();
    MoveOrientation getCurrentOrientation();

    String getName();
    String getId();
    CoOrds getStartPosition();

}
