package PokeS.Pokemon;

import PokeS.Moves.Move;

import java.util.ArrayList;

/**
 * Created by Shon on 9/25/2017.
 */
public abstract class Pokemon {
    protected String name;
    private PokeStats pokeStats;
    private ArrayList<Move> moveSet; // The current move set for this pokemon
    private ArrayList<Move> posMoves;// an ArrayList of possible move set


    /**
     * Constructor for PokeS.Trainer.Pokemon
     * @param name - the name of the pokemon
     * @param maxHealth - the maxHealth of the pokemon
     * @param moveSet - an ArrayList of moves available to this pokemon
     */
    public Pokemon(String name, int maxHealth, ArrayList<Move> moveSet){
        this.name = name;
        this.moveSet = moveSet;
    }

    public Pokemon(String name, PokeStats pokeStats, ArrayList<Move> moveSet) {
        this.name = name;
        this.pokeStats = pokeStats;
        this.moveSet = moveSet;
    }

    /**
     * Constructor for caught pokemon.
     * @param name - the name of the pokemon
     * @param maxHealth - the maxHealth of the pokemon
     * @param moveSet - an ArrayList of moves available to this pokemon
     * @param currentHealth - the current health of the pokemon.
     */
    protected Pokemon(String name, int maxHealth, ArrayList<Move> moveSet, int currentHealth){
        this.name = name;
        this.moveSet = moveSet;
    }

    /**
     * Determines the amount of dmg this pokemon will deal.
     * @param move - the move being used.
     * @return - final dmg this pokemon will deal
     */
    public int attack(Move move){
        return move.getBaseDmg();
    }

    /**
     * Deduces current from the pokemon equal to the maxHealth arguement
     * @param dmg - the amount of health to be deduced from the current maxHealth.
     * @return - the remaining maxHealth of this pokemon
     */
    public int takeDmg(int dmg){
        pokeStats.takedmg(dmg);
        return pokeStats.getCurHp();
    }

    /**
     * Calculates the current health of the pokemon. if less <= 0 returns true
     * @return true if currentHealth <=0
     */
    public boolean isFainted(){
        return getCurrentHealth() <= 0;
    }

    /**
     * Sets the possible moves for this particular pokemon
     * @param posMoves - An ArrayList of possible moves
     */
    protected void setPosMove(ArrayList<Move> posMoves){
        this.posMoves = posMoves;
    }

    /**
     * Returns the ith move in the moveSet if there is no ith element returns null.
     * @param i - the position of the move in the moveSet
     * @return - a move on the ith position in moveSet or null
     */
    public Move getMove(int i) {
        if (moveSet.size() >= i+1){
            return moveSet.get(i);
        }
        return null;
    }

    /**
     * Returns the possible moves for this pokemon.
     * @return - posMove
     */
    public ArrayList<Move> getPosMove() {
        return this.posMoves;
    }

    //Returns the maxHealth of the pokemon
    public int getMaxHealth(){
        return this.pokeStats.getHealthPoint();
    }

    public int getCurrentHealth(){
        return this.pokeStats.getCurHp();
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Move> getMoveSet(){
        return this.moveSet;
    }

    public String getStats(){
        return pokeStats.getStats();
    }

    /**
     * Creates a string with the current and max health of this pokemon.
     * @return - a string with the current/maxHealth of this pokemon.
     */
    public String getHealth(){
        return "Current Health/Max Health: " + getCurrentHealth() + "/" + getMaxHealth();
    }
}
