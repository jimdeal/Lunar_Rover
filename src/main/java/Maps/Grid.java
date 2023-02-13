package Maps;

import LunarControl.CoOrds;

public class Grid extends SimpleGrid{

    public Grid(){
    }

    public Grid(Grid grid){
        this.mapName = grid.getMapName();
        this.mapId = grid.getMapId();
        this.maxMapSize = grid.getMaxSize();
    }

    private Grid(String name, String id, CoOrds maxSize){
        // don't let this happen - would need to surround all uses in try / catch
    }

}
