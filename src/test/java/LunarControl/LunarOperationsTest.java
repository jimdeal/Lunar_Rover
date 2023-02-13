package LunarControl;

import Maps.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LunarOperationsTest {

    @Test
    public void initialiseMap(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        grid.initialiseGrid("Home", "2",maxSize);

        assertTrue(lunarOperations.addMapToMapsInUs(grid));
        assertEquals(1, lunarOperations.getNumberOfMapsInUse());

    }

    @Test
    public void getMapByName(){
        LunarOperations lunarOperations = new LunarOperations();
        Grid grid = new Grid();
        CoOrds maxSize = new CoOrds(10,10);
        grid.initialiseGrid("Home", "1",maxSize);
        assertTrue(lunarOperations.addMapToMapsInUs(grid));

        Grid grid1 = new Grid();
        CoOrds maxSize1 = new CoOrds(10,10);
        grid1.initialiseGrid("North", "2",maxSize1);
        assertTrue(lunarOperations.addMapToMapsInUs(grid1));

        Grid grid2 = new Grid();
        CoOrds maxSize2 = new CoOrds(10,10);
        grid2.initialiseGrid("South", "3",maxSize2);
        assertTrue(lunarOperations.addMapToMapsInUs(grid2));

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
        grid.initialiseGrid("Home", "1",maxSize);
        assertTrue(lunarOperations.addMapToMapsInUs(grid));

        Grid grid1 = new Grid();
        CoOrds maxSize1 = new CoOrds(10,10);
        grid1.initialiseGrid("North", "2",maxSize1);
        assertTrue(lunarOperations.addMapToMapsInUs(grid1));

        Grid grid2 = new Grid();
        CoOrds maxSize2 = new CoOrds(10,10);
        grid2.initialiseGrid("South", "3",maxSize2);
        assertTrue(lunarOperations.addMapToMapsInUs(grid2));

        assertEquals(3, lunarOperations.getNumberOfMapsInUse());
        Grid homeMap = lunarOperations.getMapById(("1"));
        assertEquals(homeMap.getMapName(), "Home");
        assertEquals(homeMap.getMapId(), "1");
        CoOrds mapSize = homeMap.getMaxSize();
        assertEquals(mapSize,maxSize);

    }

    @Test
    public void initialiseRover(){

    }
    @Test
    public void initialiseRoverFail(){

    }
    @Test
    public void addMapToOperationalCentre(){

    }

    @Test
    public void addMapsToOperationalCentre(){

    }

    @Test
    public void addRoverToOperationalCentre(){

    }

    @Test
    public void addRoversToOperationalCentre(){

    }



}