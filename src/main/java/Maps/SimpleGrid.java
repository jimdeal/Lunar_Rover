package Maps;

import LunarControl.CoOrds;
import Rover.RoverPlatform;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class SimpleGrid implements Map{
    // Implements a map.
    // In this case it is a simple X x Y grid with max size : maxMapSize.
    protected String mapName = "";
    protected String mapId = "";
    protected CoOrds maxMapSize = new CoOrds(0,0);
    protected ArrayList<RoverPosition> currentRoversInMap = new ArrayList<RoverPosition>();


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

    public boolean addRoverToMap(RoverPlatform rover){
        boolean successfulAdd = false;
        if(rover.getCurrentMap().getMapName().equals(mapName)){
            // check have we got rover on this map : no rovers in map..
            if(currentRoversInMap.size()>0){
                Iterator<RoverPosition> iterator = currentRoversInMap.iterator();
                while (iterator.hasNext()) {
                    RoverPosition roverPosition = iterator.next();
                    if ((roverPosition.roverName.equals(rover.getName())) ||
                            (roverPosition.roverId.equals(rover.getId())) ||
                            (roverPosition.roverPosition.equals(rover.getCurrentRoverPosition()))){
                        // this rover is already on this map OR the map from the rover is not this one
                        return successfulAdd;
                    }
                }
            }
            RoverPosition roverPosition = new RoverPosition();
            roverPosition.roverName = rover.getName();
            roverPosition.roverId = rover.getId();
            roverPosition.roverPosition = rover.getCurrentRoverPosition();
            roverPosition.roverOrientation = rover.getCurrentOrientation();
            currentRoversInMap.add(roverPosition);
            successfulAdd = true;
        }
        return successfulAdd;
    }

    public int numberOfRoversOnMap(){
        return currentRoversInMap.size();
    }


}
