package PokeS;

import java.util.ArrayList;

/**
 * Created by Shon on 9/30/2017.
 * The world in which trainers are created.
 */
public class PokeWorld {
    private static PokeWorld instance;
    Trainer mainChar;
    ArrayList<Trainer> trainers = new ArrayList<>();

    private PokeWorld() {

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



    /**
     * Starts the world.
     */
    public void start() {

    }
}
