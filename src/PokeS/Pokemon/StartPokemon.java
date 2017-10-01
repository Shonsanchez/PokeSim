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

    static ArrayList<Move> getStarterMoves() {
        ArrayList<Move> moveSet = new ArrayList<>();
        moveSet.add(new Tackle());
        return moveSet;
    }


}
