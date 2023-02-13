package LunarControl;

import Maps.Grid;

import java.util.ArrayList;
import java.util.Iterator;

public class LunarOperations {

    ArrayList<Grid> mapsInUse = new ArrayList<Grid>();

    public boolean addMapToMapsInUs(Grid map){
        return mapsInUse.add(map);
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

}
