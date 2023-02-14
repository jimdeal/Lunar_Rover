package LunarControl;

public class CoOrds {
    // Simple representation of co-ordinates within a map.
    public int x = 0;
    public int y = 0;

    public CoOrds(){
    }
    public CoOrds(int x, int y){
        this.x = x;
        this.y = y;
    }

    public CoOrds(CoOrds coOrds){
        this.x = coOrds.x;
        this.y = coOrds.y;
    }

    public boolean CoOrdEquals(CoOrds one){
        boolean equalsResult = false;
        if((one!=null) && (one.x == this.x) && (one.y == this.y)){
            equalsResult = true;
        }
        return equalsResult;
    }

}
