package PokeS;

import java.util.ArrayList;

/**
 * Created by Shon on 9/30/2017.
 * Class used to have pokemon battle each other.
 * Tracks attack priorities, if pokemon fainted and in charge of checking if the trainers involved have
 * any remaining pokemon
 */
public class Arena {
    private Trainer proponent;
    private Trainer opponent;

    /**
     * Constructor that takes in two trainers.
     * @param proponent - the one being fought
     * @param opponent - the opponent
     */
    protected Arena(Trainer proponent, Trainer opponent){
        this.proponent = proponent;
        this.opponent = opponent;
    }



}
