package Trainer;

import Pokemon.Pokemon;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import java.util.ArrayList;

/**
 * Created by Shon on 9/26/2017.
 */
public class Trainer {
    private String name;
    private ArrayList<Pokemon> pokeHeld;
    private ArrayList<Pokemon> pokeOwned;
    private Gender gender;

    public Trainer(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public ArrayList<Pokemon> getPokeOwned(){
        return this.pokeOwned;
    }

    /**
     * Adds a pokemon to the list of pokemon owned, adds pokemon to pokeHeld if pokeHeld is less than 6
     * @param pokemon - the pokemon to add
     */
    public void addPokemon(Pokemon pokemon){
        pokeOwned.add(pokemon);
        if (pokeHeld.size() < 6)
            pokeHeld.add(pokemon);
    }

}
