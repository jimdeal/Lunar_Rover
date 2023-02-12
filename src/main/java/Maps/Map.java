package Maps;

import LunarControl.CoOrds;

public interface Map {
    // Map : is an interface that allows users to create a new map with "template"
    // methods to name map, set it's size and check whether a given co-ordinate is within
    // the map boundary.
    // Currently set up for 2 Dimension grid
    boolean setMapId(String mapId);
    boolean setMapName(String mapName);
    boolean setMapMaxSize(CoOrds maxSize);
    boolean areCoOrdsWithinThisMap(CoOrds coOrds);
    String getMapId();
    String getMapName();
    CoOrds getMaxSize();
    boolean initialiseGrid(String name, String id, CoOrds maxSize);

}
