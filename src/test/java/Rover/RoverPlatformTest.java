package Rover;

import LunarControl.CoOrds;
import LunarControl.Move;
import LunarControl.MoveOrientation;
import Maps.Grid;
import Maps.SimpleGrid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverPlatformTest {
    @Test
    public void testConstructionAndInitialiseRoverPass(){
        RoverPlatform rover = new RoverPlatform();
        String name = new String("Huey");
        String id = new String("1");
        CoOrds maxSize = new CoOrds(10,10);
        Grid map = new Grid();
        map.initialiseGrid("Home", "1", maxSize);
        CoOrds initialPosition = new CoOrds(1,1);
        MoveOrientation initialOrientation = MoveOrientation.North;

        assertTrue(rover.initialiseRover(name, id, map, initialPosition, initialOrientation));
        assertEquals(rover.getName(), name);
        assertEquals(rover.getId(),id);
        assertEquals(rover.getStartPosition(), initialPosition);
        assertEquals(rover.getCurrentRoverPosition(), initialPosition);
        assertEquals(rover.getCurrentOrientation(),initialOrientation);
    }

    @Test
    public void testConstructionAndInitialiseRoverFail1(){
        RoverPlatform rover = new RoverPlatform();
        String name = new String("");
        String id = new String("1");
        CoOrds maxSize = new CoOrds(10,10);
        Grid map = new Grid();
        map.initialiseGrid("Home", "1", maxSize);
        CoOrds initialPosition = new CoOrds(1,1);
        MoveOrientation initialOrientation = MoveOrientation.North;

        assertFalse(rover.initialiseRover(name, id, map, initialPosition, initialOrientation));
    }

    @Test
    public void testConstructionAndInitialiseRoverFail2(){
        RoverPlatform rover = new RoverPlatform();
        String name = new String("Huey");
        String id = new String("");
        CoOrds maxSize = new CoOrds(10,10);
        Grid map = new Grid();
        map.initialiseGrid("Home", "1", maxSize);
        CoOrds initialPosition = new CoOrds(1,1);
        MoveOrientation initialOrientation = MoveOrientation.North;

        assertFalse(rover.initialiseRover(name, id, map, initialPosition, initialOrientation));
    }

    @Test
    public void testConstructionAndInitialiseRoverFail3(){
        RoverPlatform rover = new RoverPlatform();
        String name = new String("Huey");
        String id = new String("1");
        CoOrds maxSize = new CoOrds(10,10);
        Grid map = new Grid();
        CoOrds initialPosition = new CoOrds(1,1);
        MoveOrientation initialOrientation = MoveOrientation.North;

        assertFalse(rover.initialiseRover(name, id, map, initialPosition, initialOrientation));
    }

    @Test
    public void testConstructionAndInitialiseRoverFail4(){
        RoverPlatform rover = new RoverPlatform();
        String name = new String("Huey");
        String id = new String("1");
        CoOrds maxSize = new CoOrds(10,10);
        Grid map = new Grid();
        map.initialiseGrid("Home", "1", maxSize);
        CoOrds initialPosition = new CoOrds(1,1);
        MoveOrientation initialOrientation = null;

        assertFalse(rover.initialiseRover(name, id, map, initialPosition, initialOrientation));
    }

    @Test
    public void testConstructionAndInitialiseRoverChangeOrientation1(){
        RoverPlatform rover = new RoverPlatform();
        String name = new String("Huey");
        String id = new String("1");
        CoOrds maxSize = new CoOrds(10,10);
        Grid map = new Grid();
        map.initialiseGrid("Home", "1", maxSize);
        CoOrds initialPosition = new CoOrds(1,1);
        MoveOrientation initialOrientation = MoveOrientation.North;

        assertTrue(rover.initialiseRover(name, id, map, initialPosition, initialOrientation));
        assertEquals(rover.getCurrentOrientation(),initialOrientation);

        MoveOrientation changeOrientation = MoveOrientation.East;
        rover.changeOrientation(changeOrientation);
        assertEquals(rover.getCurrentOrientation(), changeOrientation);

        changeOrientation = MoveOrientation.West;
        rover.changeOrientation(changeOrientation);
        assertEquals(rover.getCurrentOrientation(), changeOrientation);

        changeOrientation = MoveOrientation.South;
        rover.changeOrientation(changeOrientation);
        assertEquals(rover.getCurrentOrientation(), changeOrientation);


    }

    @Test
    public void testConstructionAndInitialiseRoverChangeOrientation2(){
        RoverPlatform rover = new RoverPlatform();
        String name = new String("Huey");
        String id = new String("1");
        CoOrds maxSize = new CoOrds(10,10);
        Grid map = new Grid();
        map.initialiseGrid("Home", "1", maxSize);
        CoOrds initialPosition = new CoOrds(1,1);
        MoveOrientation initialOrientation = MoveOrientation.North;

        assertTrue(rover.initialiseRover(name, id, map, initialPosition, initialOrientation));
        assertEquals(rover.getCurrentOrientation(),initialOrientation);

        MoveOrientation changeOrientation = MoveOrientation.West;
        rover.changeOrientation(changeOrientation);
        assertEquals(rover.getCurrentOrientation(), changeOrientation);

        changeOrientation = MoveOrientation.East;
        rover.changeOrientation(changeOrientation);
        rover.changeOrientation(changeOrientation);
        assertEquals(rover.getCurrentOrientation(), changeOrientation);

    }

    @Test
    public void testConstructionAndInitialiseRoverMove1() {
        RoverPlatform rover = new RoverPlatform();
        String name = new String("Huey");
        String id = new String("1");
        CoOrds maxSize = new CoOrds(10, 10);
        Grid map = new Grid();
        map.initialiseGrid("Home", "1", maxSize);
        CoOrds initialPosition = new CoOrds(1, 1);
        MoveOrientation initialOrientation = MoveOrientation.North;

        assertTrue(rover.initialiseRover(name, id, map, initialPosition, initialOrientation));
        Move move = Move.Move;
        assertTrue(rover.makeMove(move));
        CoOrds newCords = new CoOrds(1,2);
        CoOrds testCoords = rover.getCurrentRoverPosition();
        assertTrue(newCords.CoOrdEquals(testCoords));

    }


    }