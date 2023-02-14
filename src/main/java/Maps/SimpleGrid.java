package Maps;

import LunarControl.CoOrds;
import LunarControl.Move;
import LunarControl.MoveOrientation;
import Rover.RoverPlatform;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class SimpleGrid implements Map{
    // Implements a map.
    // In this case it is a simple X x Y grid with max size : maxMapSize.
    protected String mapName = "";
    protected String mapId = "";
    protected CoOrds maxMapSize = new CoOrds(0,0);
    protected ArrayList<RoverPlatform> currentRoversInMap = new ArrayList<RoverPlatform>();


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
                Iterator<RoverPlatform> iterator = currentRoversInMap.iterator();
                while (iterator.hasNext()) {
                    RoverPlatform roverInMap = iterator.next();
                    if ((roverInMap.getName().equals(rover.getName())) ||
                            (roverInMap.getId().equals(rover.getId())) ||
                            (roverInMap.getCurrentRoverPosition().CoOrdEquals(rover.getCurrentRoverPosition()))){
                        // this rover is already on this map OR the map from the rover is not this one
                        return successfulAdd;
                    }
                }
            }
            currentRoversInMap.add(new RoverPlatform(rover));
            successfulAdd = true;
        }
        return successfulAdd;
    }

    public int numberOfRoversOnMap(){
        return currentRoversInMap.size();
    }

    public boolean updateRoverInMapOrientation(RoverPlatform rover){
        boolean successfulUpdate = false;
        if(rover.getCurrentMap().getMapName().equals(mapName)){
            // check have we got rover on this map : no rovers in map..
            if(currentRoversInMap.size()>0){
                Iterator<RoverPlatform> iterator = currentRoversInMap.iterator();
                while (iterator.hasNext()) {
                    RoverPlatform roverInMap = iterator.next();
                    if ((roverInMap.getName().equals(rover.getName())) ||
                            (roverInMap.getId().equals(rover.getId())) ||
                            (roverInMap.getCurrentRoverPosition().CoOrdEquals(rover.getCurrentRoverPosition()))){
                        roverInMap.changeOrientation(rover.getCurrentOrientation());
                        successfulUpdate = true;
                        return successfulUpdate;
                    }
                }
            }
            currentRoversInMap.add(new RoverPlatform(rover));
            successfulUpdate = true;
        }
        return successfulUpdate;
    }

    public RoverPlatform getRoverInMap(String name){
        RoverPlatform returnRover = null;
        // check have we got rover on this map : no rovers in map..
        if(currentRoversInMap.size()>0){
            Iterator<RoverPlatform> iterator = currentRoversInMap.iterator();
            while (iterator.hasNext()) {
                RoverPlatform roverInMap = iterator.next();
                if (roverInMap.getName().equals(name)){
//                        returnRover = new RoverPlatform();
                    returnRover = roverInMap;
                    return returnRover;
                }
            }
        }
        return null;
    }


}
