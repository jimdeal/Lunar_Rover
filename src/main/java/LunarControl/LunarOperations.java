package LunarControl;

import Maps.Grid;
import Maps.SimpleGrid;
import Rover.RoverPlatform;

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
        boolean roverAdded = false;
        if(mapsInUse.size()>0){
            Iterator<Grid> iterator = mapsInUse.iterator();
            while (iterator.hasNext()) {
                Grid map = iterator.next();
                if (map.getMapName() == rover.getCurrentMap().getMapName()) {
                    roverAdded = roversInUse.add(new RoverPlatform(rover));
                }
            }
        } else {
            roversInUse.add(new RoverPlatform(rover));
            roverAdded = true;
        }
        return roverAdded;
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

    public void changeRoverOrientation(String roverName, MoveOrientation moveOrientation){
        RoverPlatform tempRover = this.getRoverByName(roverName);
        if( tempRover != null){
            tempRover.changeOrientation(moveOrientation);
            tempRover.getCurrentMap().updateRoverInMapOrientation(tempRover);
        }
    }

    public boolean moveRover(String roverName, Move move){
        boolean opResult = false;
        RoverPlatform tempRover = this.getRoverByName(roverName);
        if( tempRover != null){
            opResult = tempRover.makeMove(move);
        }
        return opResult;
    }

    public boolean moveRoverThroughRoute(String roverName, String route) {
        boolean moveSuccessful = false;
        char[] routeArray = route.toCharArray();
        for (char c: routeArray) {
            Move move = Move.valueOf(Character.toString(c));
            // THIS method does mean that a rover will get moved..
            if(this.moveRover(roverName, move)){
                moveSuccessful = true;
            } else {
                // ...if we get here - we may only be part way through a route
                moveSuccessful = false;
                break;
            }
        }
        return moveSuccessful;
    }

    public ArrayList<MoveOrientation> getMoveOptions(String roverName) {
        ArrayList<MoveOrientation> returnMoves = new ArrayList<MoveOrientation>();
        CoOrds tempCoOrds = this.getRoverByName(roverName).getCurrentRoverPosition();
        SimpleGrid tempGrid = this.getRoverByName(roverName).getCurrentMap();

        if(tempCoOrds.x < tempGrid.getMaxSize().x){
            returnMoves.add(MoveOrientation.North);
        };
        if((tempCoOrds.x > 0)){
            returnMoves.add(MoveOrientation.South);
        }
        if(tempCoOrds.y < tempGrid.getMaxSize().y){
            returnMoves.add(MoveOrientation.East);
        };
        if((tempCoOrds.y > 0)){
            returnMoves.add(MoveOrientation.West);
        }
        return returnMoves;
    }
}
