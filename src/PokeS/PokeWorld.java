package PokeS;

import PokeS.Pokemon.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Shon on 9/30/2017.
 * The world in which trainers are created.
 */
public class PokeWorld {
    Scanner scanner = new Scanner(System.in);
    int choice;
    private static PokeWorld instance;
    Trainer mainChar;
    ArrayList<Trainer> trainers = new ArrayList<>();

    private PokeWorld() {
        Pokemon starter;
        String name;
        Gender gen;
        int choice;

        System.out.println("Hello, User, and Welcome to PokeSim! The Pokemon Simulator you'll learn to enjoy!");
        System.out.println("What is your name?");
        name = scanner.next();

        System.out.println("It's a pleasure to meet you, " + name);
        System.out.printf("Select a gender: 1) Male 2)Female (Default male)");
        choice = scanner.nextInt();
        gen = Gender.getGender(choice);
        System.out.println("You have selected " + gen);
        System.out.println("Select a pokemon: 1) Charmander 2)Bulbasaur 3)Squirtle (Default Charmander)");
        choice = scanner.nextInt();
        switch (choice){
            case 1:
                starter = new Charmander("Charmander", StartPokemon.getStarterStats(), StartPokemon.getStarterMoves());
                break;
            case 2:
                starter = new Bulbasaur("Bulbasaur", StartPokemon.getStarterStats(), StartPokemon.getStarterMoves());
                break;
            case 3:
                starter = new Squirtle("Squirtle", StartPokemon.getStarterStats(), StartPokemon.getStarterMoves());
                break;
            default:
                starter = new Charmander("Charmander", StartPokemon.getStarterStats(), StartPokemon.getStarterMoves());
                break;
        }
        Trainer trainer = new Trainer(name, gen, starter);
        System.out.println("Your name is " + trainer.getName() + " and you are a " + trainer.getGender()
                + "\nYou have picked " + starter.getName() + " as your starter pokemon.");

    }

    public static synchronized PokeWorld getInstance() {
        if (instance == null) {
            instance = new PokeWorld();
        }
        return instance;
    }

    /**
     * Creates the main character for this world.
     *
     * @param name   - the name of the trainer.
     * @param gender - the gender of the trainer.
     */
    public void createMainChar(String name, Gender gender) {
        mainChar = new Trainer(name, gender);
    }

    public void addPokemon() {

    }

    public void battle(Trainer opponent){
        Arena arena = new Arena(this.mainChar, opponent);
        while (!arena.someoneLost()){
            System.out.println(arena.selectOptions());
            choice = scanner.nextInt();
            System.out.println("You have selected option " + choice );
        }
    }

    /**
     * Starts the world.
     */
    public void start() {
    }
}
