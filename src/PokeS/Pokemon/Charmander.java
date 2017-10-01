package PokeS.Pokemon;

import PokeS.Moves.Ember;
import PokeS.Moves.Move;
import PokeS.Moves.Tackle;

import java.util.ArrayList;

/**
 * Created by Shon on 9/25/2017.
 */
public class Charmander extends Pokemon {
    /**
     * Constructor
     *
     * @param name    - the name of the pokemon
     * @param maxHealth  - the maxHealth of the pokemon
     * @param moveSet - an ArrayList of moves available to this pokemon
     */
    public Charmander(String name, int maxHealth, ArrayList<Move> moveSet) {
        super(name, maxHealth, moveSet);
        setPosMoves();
    }

    public Charmander(String name, PokeStats pokeStats, ArrayList moveSet){
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
