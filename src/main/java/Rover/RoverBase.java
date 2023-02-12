package Rover;

import LunarControl.CoOrds;
import LunarControl.Move;
import LunarControl.MoveOrientation;
import Maps.SimpleGrid;

public interface RoverBase {
    boolean initialiseRover(String name, String id, SimpleGrid map,
                            CoOrds initialPosition, MoveOrientation initialOrientation);
    boolean setMap(SimpleGrid map);
    SimpleGrid getCurrentMap();
    void changeOrientation(MoveOrientation nextOrientation);
    MoveOrientation getCurrentOrientation();
    CoOrds getCurrentRoverPosition();
    String getName();
    String getId();
    CoOrds getStartPosition();
    boolean makeMove(Move move);

}
