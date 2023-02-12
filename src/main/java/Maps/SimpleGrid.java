package Maps;

import LunarControl.CoOrds;

public abstract class SimpleGrid implements Map{
    // Implements a map.
    // In this case it is a simple X x Y grid with max size : maxMapSize.
    protected String mapName = "";
    protected String mapId = "";
    protected CoOrds maxMapSize = new CoOrds(0,0);


    public boolean setMapId(String mapId){
        boolean isNullMapid = false;
        if(!mapId.isEmpty()){
            this.mapId = mapId;
            isNullMapid = true;
        }
        return isNullMapid;
    }
    public boolean setMapName(String mapName){
        boolean isNullName= false;
        if(!mapName.isEmpty()){
            this.mapName = mapName;
            isNullName = true;
        }
        return isNullName;
    }

    public boolean setMapMaxSize(CoOrds maxSize){
        boolean isBadSize= false;
        if(maxSize.x>0 && maxSize.y>0)
        {
            this.maxMapSize = maxSize;
            isBadSize = true;
        }
        return isBadSize;
    }
    public boolean areCoOrdsWithinThisMap(CoOrds coOrds){
        return (coOrds.x<=this.maxMapSize.x && coOrds.y<=this.maxMapSize.y);
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

    public boolean initialiseGrid(String name, String id, CoOrds maxSize){
        boolean initialisePass = false;
        if(!name.isEmpty()) {
            this.mapName = name;
            if (!id.isEmpty()) {
                this.mapId = id;
                if (maxSize.x > 1 && maxSize.y > 1) {
                    this.maxMapSize = maxSize;
                    initialisePass = true;
                }
            }
        }
        return initialisePass;
    }

}
