package PokeS.Moves;

import PokeS.Pokemon.Pokemon;

/**
 * Created by Shon on 9/25/2017.
 */
public abstract class Move {
    private String moveName;
    private int baseDmg;
    private Type type;
    private ContactType contactType;
    private static int minChoice = 1;
    private static int maxChoice = 4;

    protected Move(String moveName, int baseDmg, Type type, ContactType contactType){
        this.moveName = moveName;
        this.baseDmg = baseDmg;
        this.type = type;
        this.contactType = contactType;
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
