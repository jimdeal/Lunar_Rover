package LunarControl;

import Maps.Grid;
import Maps.SimpleGrid;
import Rover.RoverPlatform;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LunarOperationsTest {

    @Test
    public void initialiseMap(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        assertTrue(grid.initialiseGrid("Home", "2",maxSize));

        assertTrue(lunarOperations.addMapToMapsInUse(grid));
        assertEquals(1, lunarOperations.getNumberOfMapsInUse());
    }

    @Test
    public void getMapByName(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        assertTrue(grid.initialiseGrid("Home", "1",maxSize));
        assertTrue(lunarOperations.addMapToMapsInUse(grid));

        Grid grid1 = new Grid();
        CoOrds maxSize1 = new CoOrds(10,10);
        assertTrue(grid1.initialiseGrid("North", "2",maxSize1));
        assertTrue(lunarOperations.addMapToMapsInUse(grid1));

        Grid grid2 = new Grid();
        CoOrds maxSize2 = new CoOrds(10,10);
        assertTrue(grid2.initialiseGrid("South", "3",maxSize2));
        assertTrue(lunarOperations.addMapToMapsInUse(grid2));

        assertEquals(3, lunarOperations.getNumberOfMapsInUse());
        Grid homeMap = lunarOperations.getMapByName(("Home"));
        assertEquals(homeMap.getMapName(), "Home");
        assertEquals(homeMap.getMapId(), "1");
        CoOrds mapSize = homeMap.getMaxSize();
        assertEquals(mapSize,maxSize);
    }

    @Test
    public void getMapById(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        assertTrue(grid.initialiseGrid("Home", "1",maxSize));
        assertTrue(lunarOperations.addMapToMapsInUse(grid));

        Grid grid1 = new Grid();
        CoOrds maxSize1 = new CoOrds(10,10);
        assertTrue(grid1.initialiseGrid("North", "2",maxSize1));
        assertTrue(lunarOperations.addMapToMapsInUse(grid1));

        Grid grid2 = new Grid();
        CoOrds maxSize2 = new CoOrds(10,10);
        assertTrue(grid2.initialiseGrid("South", "3",maxSize2));
        assertTrue(lunarOperations.addMapToMapsInUse(grid2));

        assertEquals(3, lunarOperations.getNumberOfMapsInUse());
        Grid homeMap = lunarOperations.getMapById(("1"));
        assertEquals(homeMap.getMapName(), "Home");
        assertEquals(homeMap.getMapId(), "1");
        CoOrds mapSize = homeMap.getMaxSize();
        assertEquals(mapSize,maxSize);
    }

    @Test
    public void initialiseRover(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        assertTrue(grid.initialiseGrid("Home","1",maxSize));
        CoOrds startingPosition = new CoOrds(0,0);
        RoverPlatform roverPlatform = new RoverPlatform();
        assertTrue(roverPlatform.initialiseRover("Lead", "2",grid, startingPosition, MoveOrientation.North));

        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform));
        assertEquals(1, lunarOperations.getNumberOfRoversInUse());
    }

    @Test
    public void getRoverByName(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        grid.initialiseGrid("Home","1",maxSize);
        CoOrds startingPosition = new CoOrds(0,0);
        RoverPlatform roverPlatform = new RoverPlatform();
        roverPlatform.initialiseRover("Lead", "1",grid, startingPosition, MoveOrientation.North);
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform));

        CoOrds startingPosition1 = new CoOrds(2,0);
        RoverPlatform roverPlatform1 = new RoverPlatform();
        roverPlatform1.initialiseRover("rover2", "2",grid, startingPosition1, MoveOrientation.North);
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform1));

        CoOrds startingPosition2 = new CoOrds(3,0);
        RoverPlatform roverPlatform2 = new RoverPlatform();
        roverPlatform2.initialiseRover("rover3", "3",grid, startingPosition1, MoveOrientation.North);
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform2));

        assertEquals(3, lunarOperations.getNumberOfRoversInUse());
        RoverPlatform leadRover = lunarOperations.getRoverByName(("Lead"));
        assertEquals(leadRover.getName(), "Lead");
        assertEquals(leadRover.getId(), "1");
        CoOrds mapSize = leadRover.getCurrentMap().getMaxSize();
        assertEquals(mapSize,maxSize);
    }

    @Test
    public void getRoverById(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        grid.initialiseGrid("Home","1",maxSize);
        CoOrds startingPosition = new CoOrds(0,0);
        RoverPlatform roverPlatform = new RoverPlatform();
        roverPlatform.initialiseRover("Lead", "1",grid, startingPosition, MoveOrientation.North);
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform));

        CoOrds startingPosition1 = new CoOrds(2,0);
        RoverPlatform roverPlatform1 = new RoverPlatform();
        roverPlatform1.initialiseRover("rover2", "2",grid, startingPosition1, MoveOrientation.North);
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform1));

        CoOrds startingPosition2 = new CoOrds(3,0);
        RoverPlatform roverPlatform2 = new RoverPlatform();
        roverPlatform2.initialiseRover("rover3", "3",grid, startingPosition1, MoveOrientation.North);
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform2));

        assertEquals(3, lunarOperations.getNumberOfRoversInUse());
        RoverPlatform leadRover = lunarOperations.getRoverById(("1"));
        assertEquals(leadRover.getName(), "Lead");
        assertEquals(leadRover.getId(), "1");
        CoOrds mapSize = leadRover.getCurrentMap().getMaxSize();
        assertEquals(mapSize,maxSize);
    }

    @Test
    public void testChangeOrientationOfRoverThroughController(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        grid.initialiseGrid("Home","1",maxSize);
        assertTrue(lunarOperations.addMapToMapsInUse(grid));

        CoOrds startingPosition = new CoOrds(0,0);
        RoverPlatform roverPlatform = new RoverPlatform();
        roverPlatform.initialiseRover("Lead", "1",grid, startingPosition, MoveOrientation.North);
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform));

        lunarOperations.changeRoverOrientation("Lead", MoveOrientation.West);
        RoverPlatform updatedRover = lunarOperations.getRoverByName("Lead");
        assertEquals(updatedRover.getCurrentOrientation(), MoveOrientation.West);

        RoverPlatform tempRover = lunarOperations.getRoverByName(updatedRover.getName());
        MoveOrientation tempOrientation = tempRover.getCurrentOrientation();
        assertEquals(tempOrientation, MoveOrientation.West);
    }

    @Test
    public void testChangeOrientationOfRoverThroughControllerIncorrectName(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        grid.initialiseGrid("Home","1",maxSize);
        assertTrue(lunarOperations.addMapToMapsInUse(grid));

        CoOrds startingPosition = new CoOrds(0,0);
        RoverPlatform roverPlatform = new RoverPlatform();
        roverPlatform.initialiseRover("Lead", "1",grid, startingPosition, MoveOrientation.North);
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform));

        lunarOperations.changeRoverOrientation("lunar1", MoveOrientation.West);
        RoverPlatform updatedRover = lunarOperations.getRoverByName("lunar1");
        assertEquals(updatedRover, null);
    }

    @Test
    public void doMultipleMoves(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        grid.initialiseGrid("Home","1",maxSize);
        assertTrue(lunarOperations.addMapToMapsInUse(grid));

        CoOrds startingPosition = new CoOrds(0,0);
        RoverPlatform roverPlatform = new RoverPlatform();
        roverPlatform.initialiseRover("Lead", "1",grid, startingPosition, MoveOrientation.North);
        assertTrue(roverPlatform.getCurrentMap().addRoverToMap(roverPlatform));

        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform));

        Move move = Move.M;
        assertTrue(lunarOperations.moveRover("Lead", move));
        RoverPlatform updatedRover = lunarOperations.getRoverByName("Lead");
        CoOrds newCords = new CoOrds(0,1);
        assertTrue(updatedRover.getCurrentRoverPosition().CoOrdEquals(newCords));

        move = Move.R;
        assertTrue(lunarOperations.moveRover("Lead", move));
        updatedRover = lunarOperations.getRoverByName("Lead");

        assertEquals(updatedRover.getCurrentOrientation(), MoveOrientation.East);

        RoverPlatform tempRover = lunarOperations.getRoverByName(updatedRover.getName());
        MoveOrientation tempOrientation = tempRover.getCurrentOrientation();
        assertEquals(tempOrientation, MoveOrientation.East);


        move = Move.M;
        assertTrue(lunarOperations.moveRover("Lead", move));
        updatedRover = lunarOperations.getRoverByName("Lead");
        newCords = new CoOrds(1,1);
        assertTrue(updatedRover.getCurrentRoverPosition().CoOrdEquals(newCords));

        tempRover = lunarOperations.getRoverByName(updatedRover.getName());
        CoOrds tempCoords= tempRover.getCurrentRoverPosition();
        assertTrue(tempRover.getCurrentRoverPosition().CoOrdEquals(newCords));

        SimpleGrid tempGrid = tempRover.getCurrentMap();
        RoverPlatform anotherTempRover = tempRover.getCurrentMap().getRoverInMap(tempRover.getName());
        assertTrue(anotherTempRover.getCurrentRoverPosition().CoOrdEquals(newCords));
    }

    @Test
    public void doMultipleMovesFromRoute(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        grid.initialiseGrid("Home","1",maxSize);
        assertTrue(lunarOperations.addMapToMapsInUse(grid));

        CoOrds startingPosition = new CoOrds(0,0);
        RoverPlatform roverPlatform = new RoverPlatform();
        roverPlatform.initialiseRover("Lead", "1",grid, startingPosition, MoveOrientation.North);
        assertTrue(roverPlatform.getCurrentMap().addRoverToMap(roverPlatform));
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform));

        String simpleRoute = new String("MRM");
        assertTrue(lunarOperations.moveRoverThroughRoute("Lead",simpleRoute));

        RoverPlatform updatedRover = lunarOperations.getRoverByName("Lead");
        CoOrds newCords = new CoOrds(1,1);
        assertTrue(updatedRover.getCurrentRoverPosition().CoOrdEquals(newCords));

        RoverPlatform roverPlatform1 = new RoverPlatform();
        roverPlatform1.initialiseRover("rover1", "2",grid, startingPosition, MoveOrientation.North);
        assertTrue(roverPlatform1.getCurrentMap().addRoverToMap(roverPlatform1));
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform1));

        String simpleRoute1 = new String("RMMMLM");
        assertTrue(lunarOperations.moveRoverThroughRoute("rover1",simpleRoute1));

        RoverPlatform updatedRover1 = lunarOperations.getRoverByName("rover1");
        newCords = new CoOrds(3,1);
        assertTrue(updatedRover1.getCurrentRoverPosition().CoOrdEquals(newCords));

        ArrayList<MoveOrientation> availableMoves = new ArrayList<MoveOrientation>();
        availableMoves.add(MoveOrientation.North);
        availableMoves.add(MoveOrientation.South);
        availableMoves.add(MoveOrientation.East);
        availableMoves.add(MoveOrientation.West);
        ArrayList<MoveOrientation> possibleMoves = lunarOperations.getMoveOptions("rover1");
        assertArrayEquals(availableMoves.toArray(),possibleMoves.toArray());
    }

    @Test
    public void doMultipleMovesWithFail(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        grid.initialiseGrid("Home","1",maxSize);
        assertTrue(lunarOperations.addMapToMapsInUse(grid));

        CoOrds startingPosition = new CoOrds(9,9);
        RoverPlatform roverPlatform = new RoverPlatform();
        roverPlatform.initialiseRover("Lead", "1",grid, startingPosition, MoveOrientation.North);
        assertTrue(roverPlatform.getCurrentMap().addRoverToMap(roverPlatform));
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform));

        String simpleRoute = new String("MRMM");
        assertFalse(lunarOperations.moveRoverThroughRoute("Lead",simpleRoute));

        CoOrds lastPosition = lunarOperations.getRoverByName("Lead").getCurrentRoverPosition();
        CoOrds newCords = new CoOrds(10,10);
        assertTrue(lastPosition.CoOrdEquals(newCords));

        ArrayList<MoveOrientation> availableMoves = new ArrayList<MoveOrientation>();
        availableMoves.add(MoveOrientation.South);
        availableMoves.add(MoveOrientation.West);
        ArrayList<MoveOrientation> possibleMoves = lunarOperations.getMoveOptions("Lead");

        assertArrayEquals(availableMoves.toArray(),possibleMoves.toArray());
    }

    @Test
    public void doMultipleMovesFromRouteTest1() {
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(5, 5);
        grid.initialiseGrid("Home", "1", maxSize);
        assertTrue(lunarOperations.addMapToMapsInUse(grid));

        CoOrds startingPosition = new CoOrds(1, 2);
        RoverPlatform roverPlatform = new RoverPlatform();
        roverPlatform.initialiseRover("Lead", "1", grid, startingPosition, MoveOrientation.North);
        assertTrue(roverPlatform.getCurrentMap().addRoverToMap(roverPlatform));
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform));

        String simpleRoute = new String("LMLMLMLMM");
        assertTrue(lunarOperations.moveRoverThroughRoute("Lead",simpleRoute));

        RoverPlatform updatedRover = lunarOperations.getRoverByName("Lead");
        CoOrds testCoOrds = new CoOrds(1,3);
        assertTrue(updatedRover.getCurrentRoverPosition().CoOrdEquals(testCoOrds));
        assertEquals(updatedRover.getCurrentOrientation(), MoveOrientation.North);
    }

    @Test
    public void doMultipleMovesFromRouteTest2() {
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(5, 5);
        grid.initialiseGrid("Home", "1", maxSize);
        assertTrue(lunarOperations.addMapToMapsInUse(grid));

        CoOrds startingPosition = new CoOrds(3, 3);
        RoverPlatform roverPlatform = new RoverPlatform();
        roverPlatform.initialiseRover("Lead", "1", grid, startingPosition, MoveOrientation.East);
        assertTrue(roverPlatform.getCurrentMap().addRoverToMap(roverPlatform));
        assertTrue(lunarOperations.addRoverToRoversInUse(roverPlatform));

        String simpleRoute = new String("MMRMMRMRRM");
        assertTrue(lunarOperations.moveRoverThroughRoute("Lead",simpleRoute));

        RoverPlatform updatedRover = lunarOperations.getRoverByName("Lead");
        CoOrds testCoOrds = new CoOrds(5,1);
        assertTrue(updatedRover.getCurrentRoverPosition().CoOrdEquals(testCoOrds));
        assertEquals(updatedRover.getCurrentOrientation(), MoveOrientation.East);
    }


}