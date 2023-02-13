package Maps;

import LunarControl.CoOrds;
import LunarControl.MoveOrientation;
import Rover.RoverPlatform;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    @Test
    public void mapSimpleConstructorSetAndGet(){
        Grid map = new Grid();
        String name = new String("Home");
        String id = new String("1");
        CoOrds max = new CoOrds(10,10);
        assertTrue(map.setMapName(name));
        assertTrue(map.setMapId(id));
        assertTrue(map.setMapMaxSize(max));

        assertEquals(name, map.getMapName());
        assertEquals(id, map.getMapId());
        assertEquals(max.x, map.getMaxSize().x);
    }

    @Test
    public void mapSimpleConstructorSetFailAndGet(){
        Grid map = new Grid();
        String name = new String("");
        String id = new String("");
        CoOrds max = new CoOrds(-1,10);
        assertFalse(map.setMapName(name));
        assertFalse(map.setMapId(id));
        assertFalse(map.setMapMaxSize(max));

        CoOrds max2 = new CoOrds(10,-10);
        assertFalse(map.setMapMaxSize(max2));

    }



    @Test
    public void mapSimpleConstructorTestCoOrds1(){
        Grid map = new Grid();
        String name = new String("Home");
        String id = new String("1");
        CoOrds max = new CoOrds(10,10);
        assertTrue(map.setMapName(name));
        assertTrue(map.setMapId(id));
        assertTrue(map.setMapMaxSize(max));

        assertEquals(name, map.getMapName());
        assertEquals(id, map.getMapId());
        assertEquals(max, map.getMaxSize());

        CoOrds inside = new CoOrds(2,1);
        assertTrue(map.areCoOrdsWithinThisMap(inside));

        CoOrds outside1 = new CoOrds(11,1);
        assertFalse(map.areCoOrdsWithinThisMap(outside1));

        CoOrds outside2 = new CoOrds(1,11);
        assertFalse(map.areCoOrdsWithinThisMap(outside2));
    }

    @Test
    public void mapSimpleConstructorInitialiseAndGet(){
        Grid map = new Grid();
        String name = new String("Home");
        String id = new String("1");
        CoOrds max = new CoOrds(10,10);
        assertTrue(map.initialiseGrid(name,id,max));
        assertEquals(name, map.getMapName());
        assertEquals(id, map.getMapId());
        assertEquals(max.x, map.getMaxSize().x);
    }

    @Test
    public void mapSimpleConstructorInitialiseAndGetFail1(){
        Grid map = new Grid();
        String name = new String("");
        String id = new String("1");
        CoOrds max = new CoOrds(10,10);
        assertFalse(map.initialiseGrid(name,id,max));
    }

    @Test
    public void mapSimpleConstructorInitialiseAndGetFail2(){
        Grid map = new Grid();
        String name = new String("Home");
        String id = new String("");
        CoOrds max = new CoOrds(10,10);
        assertFalse(map.initialiseGrid(name,id,max));
    }

    @Test
    public void mapSimpleConstructorInitialiseAndGetFail3(){
        Grid map = new Grid();
        String name = new String("Home");
        String id = new String("1");
        CoOrds max = new CoOrds();
        assertFalse(map.initialiseGrid(name,id,max));
    }

    @Test
    public void addRoverToMap(){
        RoverPlatform rover = new RoverPlatform();
        String name = new String("Huey");
        String id = new String("1");
        CoOrds maxSize = new CoOrds(10,10);
        Grid map = new Grid();
        map.initialiseGrid("Home", "1", maxSize);
        CoOrds initialPosition = new CoOrds(0,0);
        MoveOrientation initialOrientation = MoveOrientation.North;
        assertTrue(rover.initialiseRover(name, id, map, initialPosition, initialOrientation));
        assertTrue(map.addRoverToMap(rover));

        RoverPlatform rover1 = new RoverPlatform();
        String name1 = new String("Louie");
        String id1 = new String("2");
        CoOrds initialPosition1 = new CoOrds(1,0);
        assertTrue(rover1.initialiseRover(name1, id1, map, initialPosition1, initialOrientation));

        assertTrue(map.addRoverToMap(rover1));

    }

    @Test
    public void roverIsNotInThisMap(){
        RoverPlatform rover = new RoverPlatform();
        String name = new String("Huey");
        String id = new String("1");
        CoOrds maxSize = new CoOrds(10,10);

        Grid map = new Grid();
        map.initialiseGrid("Home", "1", maxSize);

        Grid map2 = new Grid();
        map2.initialiseGrid("North", "2", maxSize);

        CoOrds initialPosition = new CoOrds(0,0);
        MoveOrientation initialOrientation = MoveOrientation.North;
        assertTrue(rover.initialiseRover(name, id, map2, initialPosition, initialOrientation));

        assertFalse(map.addRoverToMap(rover));

    }

    @Test
    public void roverIsAlreadyInMap(){
        RoverPlatform rover = new RoverPlatform();
        String name = new String("Huey");
        String id = new String("1");
        CoOrds maxSize = new CoOrds(10,10);
        Grid map = new Grid();
        map.initialiseGrid("Home", "1", maxSize);
        CoOrds initialPosition = new CoOrds(0,0);
        MoveOrientation initialOrientation = MoveOrientation.North;
        assertTrue(rover.initialiseRover(name, id, map, initialPosition, initialOrientation));
        assertTrue(map.addRoverToMap(rover));

        RoverPlatform rover1 = new RoverPlatform();
        String name1 = new String("Huey");
        String id1 = new String("2");
        CoOrds initialPosition1 = new CoOrds(1,0);
        assertTrue(rover1.initialiseRover(name1, id1, map, initialPosition1, initialOrientation));
        assertFalse(map.addRoverToMap(rover1));

        RoverPlatform rover2 = new RoverPlatform();
        String name2 = new String("Louie");
        String id2 = new String("1");
        CoOrds initialPosition2 = new CoOrds(0,1);
        assertTrue(rover2.initialiseRover(name2, id2, map, initialPosition2, initialOrientation));
        assertFalse(map.addRoverToMap(rover2));

        RoverPlatform rover3 = new RoverPlatform();
        String name3 = new String("Duey");
        String id3 = new String("3");
        assertTrue(rover3.initialiseRover(name3, id3, map, initialPosition, initialOrientation));
        assertFalse(map.addRoverToMap(rover3));

        assertEquals(1,map.numberOfRoversOnMap());

    }

}