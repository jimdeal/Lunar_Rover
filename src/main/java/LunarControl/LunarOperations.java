package LunarControl;

import Maps.Grid;
import Rover.RoverPlatform;
import Rover.SimpleRoverImpl;

import java.util.ArrayList;
import java.util.Iterator;

public class LunarOperations {

    ArrayList<Grid> mapsInUse = new ArrayList<Grid>();
    ArrayList<RoverPlatform> roversInUse = new ArrayList<RoverPlatform>();

    public boolean addMapToMapsInUse(Grid map){
        return mapsInUse.add(new Grid(map));
    }
    public int getNumberOfMapsInUse(){
        return mapsInUse.size();
    }

    public Grid getMapByName(String mapName){
        Iterator<Grid> iterator = mapsInUse.iterator();
        while (iterator.hasNext()) {
            Grid grid = iterator.next();
            if (grid.getMapName().equals(mapName)) {
                return grid;
            }
        }
        return null;

    }

    public Grid getMapById(String id){
        Iterator<Grid> iterator = mapsInUse.iterator();
        while (iterator.hasNext()) {
            Grid grid = iterator.next();
            if (grid.getMapId().equals(id)) {
                return grid;
            }
        }
        return null;

    }

    public boolean addRoverToRoversInUse(RoverPlatform rover){
        return roversInUse.add(rover);
    }
    public int getNumberOfRoversInUse(){
        return roversInUse.size();
    }

    public RoverPlatform getRoverByName(String roverName){
        Iterator<RoverPlatform> iterator = roversInUse.iterator();
        while (iterator.hasNext()) {
            RoverPlatform rover = iterator.next();
            if (rover.getName().equals(roverName)) {
                return rover;
            }
        }
        return null;

    }

    public RoverPlatform getRoverById(String id){
        Iterator<RoverPlatform> iterator = roversInUse.iterator();
        while (iterator.hasNext()) {
            RoverPlatform rover = iterator.next();
            if (rover.getId().equals(id)) {
                return rover;
            }
        }
        return null;

    }


}
