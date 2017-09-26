package Pokemon;

import Moves.Move;
import Moves.Tackle;
import Pokemon.Pokemon;

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
        pokeList.add(new Charmander("Max", 30, moveSet));
        pokeList.add(new Charmander("Sam", 28, moveSet));
        return pokeList;
    }
}
