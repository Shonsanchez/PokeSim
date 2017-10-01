package PokeS;

import PokeS.Pokemon.Pokemon;

import java.util.ArrayList;

/**
 * Created by Shon on 9/26/2017.
 */
public class Trainer {
    private String name;
    private ArrayList<Pokemon> pokeHeld = new ArrayList<>();
    private ArrayList<Pokemon> pokeOwned = new ArrayList<>();
    private Gender gender;

    public Trainer(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Trainer(String name, Gender gender, Pokemon firstPoke){
        this.name = name;
        this.gender = gender;
        pokeHeld.add(firstPoke);
        pokeHeld.add(firstPoke);
    }

    /**
     * Used to return a list of pokemon caught.
     * @return - pokeOwned.
     */
    public ArrayList<Pokemon> getPokeOwned(){
        return this.pokeOwned;
    }

    /**
     * Adds a pokemon to the list of pokemon owned, adds pokemon to pokeHeld if pokeHeld is less than 6
     * @param pokemon - the pokemon to add
     */
    public void addPokemon(Pokemon pokemon){
        if (!pokeOwned.contains(pokemon))
            pokeOwned.add(pokemon);
        if (pokeHeld.size() < 6)
            pokeHeld.add(pokemon);
    }


    /**
     * The method creates a new list and loops through pokeHeld and adds pokemon that have more
     * than 0 healthPoints.
     * @return - An ArrayList of non fainted pokemon.
     */
    public ArrayList<Pokemon> getNonFaintedPoke(){
        ArrayList<Pokemon> nonFaintedPoke = new ArrayList<>();
        for (Pokemon poke : pokeHeld) {
            if (poke.getCurrentHealth() > 0) {
                nonFaintedPoke.add(poke);
            }
        }
        return nonFaintedPoke;
    }

    /**
     * Goes through the list of pokemon held to check if the trainer has any pokemon
     * with more than 0 health.
     * @return - if the trainer is holding a pokemon with more than 1 healthPoint.
     */
    public boolean hasNonFaintedPoke(){
        for (Pokemon poke: pokeHeld){
            if (poke.getCurrentHealth() > 0)
                return true;
        }
        return false;
    }

    /**
     * Checks if there are non fainted pokemons, if there are returns the first on in the list,
     * Else returns null;
     * @return - first non fainted pokemon, else null.
     */
    public Pokemon getFirstNonFaintedPoke(){
        if(hasNonFaintedPoke()){
            return getNonFaintedPoke().get(0);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pokemon> getPokeHeld() {
        return pokeHeld;
    }

    public void setPokeHeld(ArrayList<Pokemon> pokeHeld) {
        this.pokeHeld = pokeHeld;
    }

    public void setPokeOwned(ArrayList<Pokemon> pokeOwned) {
        this.pokeOwned = pokeOwned;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
