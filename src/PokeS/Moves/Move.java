package PokeS.Moves;

import PokeS.Items.Potion;
import PokeS.Pokemon.Pokemon;

/**
 * Created by Shon on 9/25/2017.
 */
public abstract class Move {
    private String moveName;
    private int baseDmg;
    private int type;
    private static int minChoice = 1;
    private static int maxChoice = 4;

    protected Move(String moveName, int baseDmg){
        this.moveName = moveName;
        this.baseDmg = baseDmg;
    }

    public int calculateDmg(Pokemon attaker, Pokemon Defender) {
        return ((((2 * attaker.getLvl()) / 5) + 2) * attaker.getAttack()/Defender.getDefense() * baseDmg)/50 + 2;
    }

    public int getBaseDmg(){
        return this.baseDmg;
    }

    public String getMoveName(){
        return moveName;
    }

    public static int getMinChoice() {
        return minChoice;
    }

    public static int getMaxChoice() {
        return maxChoice;
    }
}
