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

    public boolean CoOrdEquals(CoOrds one){
        boolean equalsResult = false;
        if((one.x == this.x) && (one.y == this.y)){
            equalsResult = true;
        }
        return equalsResult;
    }

}
