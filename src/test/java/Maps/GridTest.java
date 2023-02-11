package Maps;

import LunarControl.CoOrds;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    @Test
    public void mapSimpleConstructorAndGet(){
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
    public void mapSimpleConstructorAndGetFails(){
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



}