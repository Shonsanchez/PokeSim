import Moves.Ember;
import Pokemon.Pokemon;
import Pokemon.PokemonGenerator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Shon on 9/25/2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, User, and Welcome to PokeSim! The Pokemon.Pokemon Simulator you'll learn to enjoy!");
       // System.out.println("Please select a pokemon: ");

        ArrayList<Pokemon> pokeList = PokemonGenerator.genPokemon();
        for (Pokemon pokemon: pokeList){
            System.out.println("Pokemon's Name: " + pokemon.getName());
            System.out.println("Pokemon's maxHealth: " + pokemon.getMaxHealth());
        }

        Pokemon max = pokeList.get(0);
        Pokemon sam = pokeList.get(1);
        System.out.println("Sam's current health is " + sam.getCurrentHealth());
        sam.takeDmg(max.attack(max.getMoveSet().get(0)));
        System.out.println("Max used tackle on Sam. Same lost " + max.getMoveSet().get(0).getBaseDmg() + " dmg.");
        System.out.println("Sam's current health is " + sam.getCurrentHealth());
    }
}
