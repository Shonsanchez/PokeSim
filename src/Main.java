import Pokemon.Pokemon;
import Pokemon.PokemonGenerator;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Shon on 9/25/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Hello, User, and Welcome to PokeSim! The Pokemon.Pokemon Simulator you'll learn to enjoy!");
        System.out.println("Please select a pokemon: ");
        ArrayList<Pokemon> pokeList =PokemonGenerator.genPokemon();
        for (Pokemon pokemon: pokeList){
            System.out.println("Pokemon's Name: " + pokemon.getName());
            System.out.println("Pokemon's maxHealth: " + pokemon.getmaxHealth());
        }
    }
}
