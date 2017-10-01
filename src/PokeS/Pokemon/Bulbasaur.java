package PokeS.Pokemon;

import PokeS.Moves.Ember;
import PokeS.Moves.Move;
import PokeS.Moves.Tackle;

import java.util.ArrayList;

/**
 * Created by Shon on 9/29/2017.
 */
public class Bulbasaur extends Pokemon implements StartPokemon {
    /**
     * Constructor
     *
     * @param name    - the name of the pokemon
     * @param maxHealth  - the maxHealth of the pokemon
     * @param moveSet - an ArrayList of moves available to this pokemon
     */
    public Bulbasaur(String name, int maxHealth, ArrayList<Move> moveSet) {
        super(name, maxHealth, moveSet);
        setPosMoves();
    }



    public Bulbasaur(String name, PokeStats pokeStats, ArrayList moveSet){
        super(name,pokeStats,moveSet);
    }

    /**
     * Sets the possible moves for this particular pokemon
     */
    private void setPosMoves(){
        ArrayList<Move> posMoves = new ArrayList<>();
        posMoves.add(new Tackle());
        posMoves.add(new Ember());
        super.setPosMove(posMoves);
    }
}
