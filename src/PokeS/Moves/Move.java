package PokeS.Moves;

/**
 * Created by Shon on 9/25/2017.
 */
public abstract class Move {
    private String moveName;
    private int baseDmg;
    private int type;

    protected Move(String moveName, int baseDmg){
        this.moveName = moveName;
        this.baseDmg = baseDmg;
    }

    public int getBaseDmg(){
        return this.baseDmg;
    }

    public String getMoveName(){
        return moveName;
    }
}
