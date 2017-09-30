import Moves.Move;
import Moves.Tackle;
import Pokemon.Pokemon;
import Pokemon.Bulbasaur;
import Pokemon.Squirtle;
import Pokemon.Charmander;
import Trainer.Gender;
import Trainer.Trainer;
import Pokemon.PokeStats;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Shon on 9/25/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, User, and Welcome to PokeSim! The Pokemon Simulator you'll learn to enjoy!");
        System.out.println("What is your name?");
        String name = scanner.next();
        Trainer trainer = new Trainer(name,Gender.MALE);
        System.out.println("Hey, " + trainer.getName() + " it is a pleasure to meet you.");
        PokeStats b = new PokeStats(5,45,49,49,65,65,45);
        PokeStats c = new PokeStats(5,39,52,43,60,50,65);
        PokeStats s = new PokeStats(5,44,48,65,50,64,43);
        ArrayList<Move> moveSet = new ArrayList<>();
        moveSet.add(new Tackle());
        Pokemon bulb = new Bulbasaur("Bulbasaur" , b , moveSet);
        Pokemon charmandar = new Charmander("Charmander", c, moveSet);
        Pokemon squirt = new Squirtle("Squirtle", s, moveSet);
        ArrayList<Pokemon> pokeList = new ArrayList();
        pokeList.add(bulb);
        pokeList.add(charmandar);
        pokeList.add(squirt);
        int counter = 1;
        System.out.println("Pick a pokemon: ");
        for (Pokemon pokemon : pokeList) {
            System.out.println(counter++ + ") " + pokemon.getName());
        }
        Pokemon chosenPokemon;
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                chosenPokemon = bulb;
                break;
            case 2:
                chosenPokemon = charmandar;
                break;
            case 3:
                chosenPokemon = squirt;
                break;
            default:
                chosenPokemon = bulb;
                break;
        }
        Pokemon garyPoke = new Charmander("Char" , c, moveSet);
        System.out.println("You have selected " + chosenPokemon.getName());
        System.out.println(chosenPokemon.getName() + " has the following stats\n" + chosenPokemon.getStats() + "\n");
        System.out.println("You will be challenged by Gary, also a new Trainer.");
        System.out.println("Let the battles begin. Gary has a " + garyPoke.getName() +
        " and it stats are \n" + charmandar.getStats());

        System.out.println("Gary's pokemon's health = " + garyPoke.getCurrentHealth());
        while(garyPoke.getCurrentHealth() > 0){
            System.out.println("Select an attack");
            counter = 1;
            for (Move move: chosenPokemon.getMoveSet()){
                System.out.println(counter + ") " + move.getMoveName());
            }
            choice = scanner.nextInt();
            garyPoke.takeDmg(chosenPokemon.attack(chosenPokemon.getMoveSet().get(choice - 1)));
            System.out.println("Stat's of Gary's Pokemon\n" + garyPoke.getStats());
        }

        System.out.println("You've won!");


    }
}
