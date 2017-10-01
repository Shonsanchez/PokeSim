package PokeS.Pokemon;

import PokeS.Moves.Ember;
import PokeS.Moves.Move;
import PokeS.Moves.Tackle;

import java.util.ArrayList;

/**
 * Created by Shon on 9/25/2017.
 */
public class PokemonGenerator {
    private static ArrayList<Pokemon> pokeList = new ArrayList<Pokemon>();

    /**
     * Generates pokemon
     * @return - an ArrayList of pokemon
     */
    public static ArrayList<Pokemon> genPokemon(){
        ArrayList<Move> moveSet = new ArrayList<>();
        moveSet.add(new Tackle());
        moveSet.add(new Ember());
        pokeList.add(new Charmander("Max", 30, moveSet));
        pokeList.add(new Charmander("Sam", 28, moveSet));
        return pokeList;
    }
}
