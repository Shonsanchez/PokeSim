package PokeS;

import PokeS.Moves.Move;
import PokeS.Pokemon.Pokemon;

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
    Pokemon currPoke;
    Pokemon oppPoke;

    /**
     * Constructor that takes in two trainers.
     * @param proponent - the one being fought
     * @param opponent - the opponent
     */
    protected Arena(Trainer proponent, Trainer opponent){
        this.proponent = proponent;
        this.opponent = opponent;
        currPoke = proponent.getFirstNonFaintedPoke();
        oppPoke = opponent.getFirstNonFaintedPoke();
    }

    /**
     * Forms a string with the beginning options to a battle.
     * @return - a string with options.
     */
    public String selectOptions(){
        return "1) Attack   2)Switch\n3)Run";
    }

    /**
     * Creates a string with the list of moves for the selected pokemon.
     * @return - a string with a list of moves for the selected pokemon.
     */
    public String selectMoves(){
        String result = "";
        int cnt = 1;
        for(Move move: currPoke.getMoveSet()){
            result += cnt++ + ") " + move.getMoveName() + "\n";
        }
        return result;
    }

    /**
     * Deducts health from the opponent's pokemon based on base dmg of move and
     * forms a string of the amount of dmg done.
     * @param move - the move being used.
     * @return - a String of the amount of dmg dealt.
     */
    public String useMove(Move move){
        int dmg = move.getBaseDmg();
        oppPoke.takeDmg(dmg);
        String result = currPoke.getName() + " did " + dmg + " damage.\n";
        if (oppPoke.isFainted()){
            result += oppPoke.getName() + " Fainted.";
        }else {
            result+= oppPoke.getHealth();
        }
        return result;
    }

    /**
     * Checks if either trainer has no non fainted pokemon.
     * @return - if either trainer has no more non fainted pokemon.
     */
    public boolean someoneLost(){
        return !proponent.hasNonFaintedPoke() || !opponent.hasNonFaintedPoke();
    }

    /**
     * Begins the battle between the two trainers. Returns if the proponent won the battle.
     * Who ever has no non fainted pokemon loses.
     * @return - if the proponent won the battle
     */
    public boolean startBattle(){
        return true;
    }


}
