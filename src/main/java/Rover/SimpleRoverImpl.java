package Rover;

import LunarControl.CoOrds;
import LunarControl.Move;
import LunarControl.MoveOrientation;
import Maps.Grid;
import Maps.Map;
import Maps.SimpleGrid;

import java.util.ArrayList;

public abstract class SimpleRoverImpl implements RoverBase{
    protected String roverName = "";
    protected String roverId = "";
    protected SimpleGrid currentMap = new Grid();
    protected CoOrds startPosition = new CoOrds(0,0);
    protected CoOrds currentPosition = new CoOrds(0,0);
    protected MoveOrientation currentOrientation = MoveOrientation.North;
    protected ArrayList<String> movesLog = new ArrayList<String>();

    public boolean initialiseRover(String name, String id, SimpleGrid map,
                                   CoOrds initialPosition, MoveOrientation initialOrientation){
        boolean initialisePass = false;
        if(!name.isEmpty()){
            this.roverName = name;
            if(!id.isEmpty()){
                this.roverId = id;
                if(map != null){
                    this.currentMap = map; // links incoming map and currentmap
                    // will need to add rover to map AFTER intialisation is complete
                    if((initialPosition.x>=0 && initialPosition.x<=map.getMaxSize().x) &&
                            (initialPosition.y>=0 && initialPosition.y<=map.getMaxSize().y)) {
                        this.startPosition = new CoOrds(initialPosition);
                        this.currentPosition = new CoOrds(initialPosition);
                        if(initialOrientation != null)
                        {
                            this.logMove("Init");
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
        if(nextOrientation!=null){
            this.currentOrientation = nextOrientation;
        }
    }

    private void logMove(String justMoved){
        if(!justMoved.isEmpty()){
            this.movesLog.add(justMoved);
        }
    }

    ArrayList<String> getLog(){
        return this.movesLog;
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
        if(move!=null){
            if(move==Move.M){
                switch (this.currentOrientation) {
                    case North:
                        if ((this.currentOrientation == MoveOrientation.North) &&
                                ((this.currentPosition.y + 1) <= this.currentMap.getMaxSize().y)) {
                            this.currentPosition.y++;
                            this.logMove(move.toString());

                            moveSuccessful = true;
                        }
                        break;
                    case East:
                        if ((this.currentOrientation == MoveOrientation.East) &&
                                ((this.currentPosition.x + 1) <= this.currentMap.getMaxSize().x)) {
                            this.currentPosition.x++;
                            this.logMove(move.toString());
                            moveSuccessful = true;
                        }
                        break;
                    case South:
                        if ((this.currentOrientation == MoveOrientation.South) &&
                                ((this.currentPosition.y - 1) >= 0)) {
                            this.currentPosition.y--;
                            this.logMove(move.toString());
                            moveSuccessful = true;
                        }
                        break;
                    case West:
                        if ((this.currentOrientation == MoveOrientation.West) &&
                                ((this.currentPosition.x - 1) >= 0)) {
                            this.currentPosition.x--;
                            this.logMove(move.toString());
                            moveSuccessful = true;
                        }
                        break;
                    default:
                        break;
                }
            } else if (move == Move.R){
                this.logMove(move.toString());
                if(this.currentOrientation.ordinal()==3){
                    this.currentOrientation = MoveOrientation.North;
                } else {
                    MoveOrientation tempMove = MoveOrientation.values()[this.currentOrientation.ordinal() +1];
                    this.currentOrientation = tempMove;
                }
                moveSuccessful = true;
            } else if (move == Move.L){
                this.logMove(move.toString());
                if(this.currentOrientation.ordinal()==0){
                    this.currentOrientation = MoveOrientation.West;
                } else {
                    MoveOrientation tempMove = MoveOrientation.values()[this.currentOrientation.ordinal() -1];
                    this.currentOrientation = tempMove;
                }
                moveSuccessful = true;
            } else {
                //
            }
        }
        return moveSuccessful;
    }

}
