package Maps;

import LunarControl.CoOrds;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    @Test
    public void mapSimpleConstructorAndGet(){
        CoOrds max = new CoOrds(10,10);
        Grid map = new Grid("Home", "1", max);

        assertEquals(map.getMapName(), "Home");
        assertEquals(map.getMapId(), "1");
        assertEquals(map.getMaxSize(), max);

    }

}