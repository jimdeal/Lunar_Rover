package Maps;

import LunarControl.CoOrds;

public abstract class SimpleGrid implements Map{
    // Implements a map.
    // In this case it is a simple X x Y grid with max size : maxMapSize.
    private String mapName;
    private String mapId;
    private CoOrds maxMapSize;


    public void setMapId(String mapId){

    }
    public void setMapName(String mapName){

    }
    public void setMapMaxSize(CoOrds maxSize){

    }
    public boolean areCoOrdsWithinThisMap(CoOrds coOrds){
        return false;
    }

}
