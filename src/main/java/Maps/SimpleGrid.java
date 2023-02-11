package Maps;

import LunarControl.CoOrds;

public abstract class SimpleGrid implements Map{
    // Implements a map.
    // In this case it is a simple X x Y grid with max size : maxMapSize.
    protected String mapName;
    protected String mapId;
    protected CoOrds maxMapSize;


    public void setMapId(String mapId){
        this.mapId = mapId;
    }
    public void setMapName(String mapName){
        this.mapName = mapName;
    }

    public void setMapMaxSize(CoOrds maxSize){
        this.maxMapSize = maxSize;
    }
    public boolean areCoOrdsWithinThisMap(CoOrds coOrds){
        return false;
    }
    public String getMapId(){
        return this.mapId;
    }
    public String getMapName(){
        return this.mapName;
    }
    public CoOrds getMaxSize(){
        return this.maxMapSize;
    }


}
