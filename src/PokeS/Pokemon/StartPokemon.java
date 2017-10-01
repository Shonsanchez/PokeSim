package PokeS.Pokemon;

import PokeS.Moves.Move;
import PokeS.Moves.Tackle;

import java.util.ArrayList;

/**
 * Created by Shon on 10/1/2017.
 */
public interface StartPokemon {
    static PokeStats getStarterStats() {
        return new PokeStats(5,50,50,50,50,50,50);
    }

    /**
     * Creates starter stats with higher health, defense, and spDefense.
     * @return - pokestats.
     */
    static PokeStats getTankStarterStats() {
        return new PokeStats(5,60,40,55,40,55,50);
    }

    /**
     * Creates starter stats with higher attack and speed stats and lower health and defense
     * @return - Pokestats.
     */
    static PokeStats getDmgStaterStats() {
        return new PokeStats(5,39,66,40,50,50,55);
    }
    static ArrayList<Move> getStarterMoves() {
        ArrayList<Move> moveSet = new ArrayList<>();
        moveSet.add(new Tackle());
        return moveSet;
    }


}
