package Rover;

import LunarControl.CoOrds;
import LunarControl.Move;
import LunarControl.MoveOrientation;
import Maps.Grid;
import Maps.Map;
import Maps.SimpleGrid;

import java.util.ArrayList;

public abstract class SimpleRoverImpl implements RoverBase{
    private String roverName = "";
    private String roverId = "";
    private SimpleGrid currentMap = new Grid();
    private CoOrds startPosition = new CoOrds(0,0);
    private CoOrds currentPosition = new CoOrds(0,0);
    private MoveOrientation currentOrientation = MoveOrientation.North;
    private ArrayList<MoveOrientation> movesLog = new ArrayList<MoveOrientation>();

    public boolean initialiseRover(String name, String id, SimpleGrid map,
                                   CoOrds initialPosition, MoveOrientation initialOrientation){
        boolean initialisePass = false;
        if(!name.isEmpty()){
            this.roverName = name;
            if(!id.isEmpty()){
                this.roverId = id;
                if(map != null){
                    this.currentMap = map;
                    if((initialPosition.x>=0 && initialPosition.x<=map.getMaxSize().x) &&
                            (initialPosition.y>=0 && initialPosition.y<=map.getMaxSize().y)) {
                        this.startPosition = initialPosition;
                        this.currentPosition = initialPosition;
                        if(initialOrientation != null)
                        {
                            this.currentOrientation = initialOrientation;
                            initialisePass = true;
                        }
                    }
                }
            }
        }
        return initialisePass;
    }
    public boolean setMap(SimpleGrid map){
        boolean setMapFail = false;
        if(map != null) {
            this.currentMap = map;
            setMapFail = true;
        }
        return setMapFail;
    }
    public void changeOrientation(MoveOrientation nextOrientation){
        this.currentOrientation = nextOrientation;
    }

    private void logMove(MoveOrientation justMoved){
        this.movesLog.add(justMoved);
    }

    public SimpleGrid getCurrentMap(){
        return this.currentMap;
    }

    public CoOrds getCurrentRoverPosition(){
        return this.currentPosition;
    }

    public MoveOrientation getCurrentOrientation(){
        return this.currentOrientation;
    }

    public String getName(){
        return this.roverName;
    }
    public String getId(){
        return this.roverId;
    }
    public CoOrds getStartPosition(){
        return this.startPosition;
    }

    public boolean makeMove(Move move){
        boolean moveSuccessful = false;
        if(move==Move.Move){
            switch (this.currentOrientation) {
                case North:
                    if ((this.currentOrientation == MoveOrientation.North) &&
                            ((this.currentPosition.y + 1) <= this.currentMap.getMaxSize().y)) {
                        this.currentPosition.y++;
                        moveSuccessful = true;
                    }
                    break;
                case East:
                    if ((this.currentOrientation == MoveOrientation.East) &&
                            ((this.currentPosition.x + 1) <= this.currentMap.getMaxSize().x)) {
                        this.currentPosition.x++;
                        moveSuccessful = true;
                    }
                    break;
                case South:
                    if ((this.currentOrientation == MoveOrientation.South) &&
                            ((this.currentPosition.y - 1) >= 0)) {
                        this.currentPosition.y--;
                        moveSuccessful = true;
                    }
                    break;
                case West:
                    if ((this.currentOrientation == MoveOrientation.West) &&
                            ((this.currentPosition.x - 1) >= 0)) {
                        this.currentPosition.x--;
                        moveSuccessful = true;
                    }
                    break;
                default:
                    break;
            }
        } else if (move == Move.Right){
            if(this.currentOrientation.ordinal()==3){
                this.currentOrientation = MoveOrientation.North;
            } else {
                MoveOrientation tempMove = MoveOrientation.values()[this.currentOrientation.ordinal() +1];
                this.currentOrientation = tempMove;
            }
        }
        return moveSuccessful;
    }


}
