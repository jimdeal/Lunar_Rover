package LunarControl;

import Maps.Grid;
import Rover.RoverPlatform;
import org.junit.jupiter.api.Test;

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



    }

    @Test
    public void testChangeOrientationOfRoverThroughControllerIncorrectMap1(){


    }





}