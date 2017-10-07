package PokeS.Items;

import PokeS.Pokemon.Pokemon;

/**
 * Created by Shon on 10/2/2017.
 */
public class BasicPotion extends Item implements Potion {

    public BasicPotion() {
        super("BasicPotion", 1);
        setRestore(20);
    }

    /**
     * Constructor that takes in the amount of uses
     * @param uses - the amount of times this item can be used.
     */
    public BasicPotion(int uses) {
        super("BasicPotion", uses);
    }

    @Override
    public String use(Pokemon pokemon){
        if (getUses() > 0){
            deductUses(1);
            int healthRestored = pokemon.restoreHealth(getRestore());
            return pokemon.getName() + " restored " + healthRestored + " health.\n" + pokemon.getHealth();
        }
        return "You don't have any " + this.getItemName();
    }
}
