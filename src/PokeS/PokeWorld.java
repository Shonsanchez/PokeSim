package PokeS;

import PokeS.Items.Potion;
import PokeS.Pokemon.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Shon on 9/30/2017.
 * A singleton class.
 * The world in which trainers are created.
 */
public class PokeWorld {
    Scanner scanner = new Scanner(System.in);
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
                starter = new Charmander("Charmander", StartPokemon.getDmgStaterStats(), StartPokemon.getStarterMoves());
                break;
            case 2:
                starter = new Bulbasaur("Bulbasaur", StartPokemon.getTankStarterStats(), StartPokemon.getStarterMoves());
                break;
            case 3:
                starter = new Squirtle("Squirtle", StartPokemon.getStarterStats(), StartPokemon.getStarterMoves());
                break;
            default:
                starter = new Charmander("Charmander", StartPokemon.getStarterStats(), StartPokemon.getStarterMoves());
                break;
        }
        createMainChar(name, gen, starter);
        mainChar.addItem(new Potion());
        System.out.println("Your name is " + mainChar.getName() + " and you are a " + mainChar.getGender()
                + "\nYou have picked " + starter.getName() + " as your starter pokemon.");
        Trainer gary = createGary();
        System.out.println("You will be challenging your first opponent: " + gary.getName() + "\n");
        System.out.println("He has a " + gary.getStarterPokemon().getName() + " with the following stats\n" + gary.getStarterPokemon().getStats() + "\n");
        System.out.println("Your pokemon has the following stats: \n" + mainChar.getStarterPokemon().getStats() + "\n");
        battle(gary);
    }

    /**
     * Creates the first opponent.
     * @return - a new trainer.
     */
    private Trainer createGary(){
        Pokemon garyPoke = new Charmander("Lil Char", StartPokemon.getStarterStats(), StartPokemon.getStarterMoves2());
        return new Trainer("Gary", Gender.MALE, garyPoke);
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
     * @param starter - the trainer's starter pokemon
     */
    public void createMainChar(String name, Gender gender, Pokemon starter) {
        mainChar = new Trainer(name, gender, starter);
    }

    public void addPokemon() {

    }

    /**
     * Initiates the battle between two trainers.
     * @param opponent - the opponent trainer
     */
    private void battle(Trainer opponent){
        Arena arena = new Arena(this.mainChar, opponent);
        arena.startBattle();
    }
    /**
     * Starts the world.
     */
    public void start() {

    }
}
