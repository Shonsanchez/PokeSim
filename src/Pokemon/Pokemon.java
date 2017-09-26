package Pokemon;

import Moves.Move;

import java.util.ArrayList;

/**
 * Created by Shon on 9/25/2017.
 */
public abstract class Pokemon {
    protected String name;
    private int health;
    private ArrayList<Move> moveSet; // The current move set for this pokemon
    private ArrayList<Move> posMoves;// an ArrayList of possible move set


    /**
     * Constructor
     * @param name - the name of the pokemon
     * @param health - the health of the pokemon
     * @param moveSet - an ArrayList of moves available to this pokemon
     */
    protected Pokemon(String name, int health, ArrayList<Move> moveSet){
        this.name = name;
        this.health = health;
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
     * Deduces health from the pokemon equal to the health arguement
     * @param health - the amount of health to be deduced from the current health.
     * @return - the remaining health of this pokemon
     */
    public int takeDmg(int health){
        this.health -= health;
        return health;
    }

    /**
     * Sets the possible moves for this particular pokemon
     * @param posMoves - An ArrayList of possible moves
     */
    protected void setPosMove(ArrayList<Move> posMoves){
        this.posMoves = posMoves;
    }

    //Returns the health of the pokemon
    public int getHealth(){
        return this.health;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Move> getMoveSet(){
        return this.moveSet;
    }
}
