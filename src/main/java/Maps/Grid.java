package Maps;

import LunarControl.CoOrds;

public class Grid extends SimpleGrid{

    public Grid(String name, String id, CoOrds maxSize){
        this.mapName = name;
        this.mapId = id;
        this.maxMapSize = maxSize;
    }

}
