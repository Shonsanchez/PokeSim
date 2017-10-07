package PokeS.Pokemon;

import PokeS.Moves.Move;

import java.util.ArrayList;

/**
 * Created by Shon on 10/6/2017.
 */
public class Pikachu extends Pokemon {
    public Pikachu(String name, int maxHealth, ArrayList<Move> moveSet) {
        super(name, maxHealth, moveSet);
    }

    public Pikachu(String name, PokeStats pokeStats, ArrayList<Move> moveSet) {
        super(name, pokeStats, moveSet);
    }

}
