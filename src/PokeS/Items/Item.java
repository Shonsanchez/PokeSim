package PokeS.Items;

import PokeS.Pokemon.Pokemon;

/**
 * Created by Shon on 10/2/2017.
 */
public abstract class Item {
    private int uses;
    private String itemName;
    private int restore;

    protected Item(String name, int uses){
        this.itemName = name;
        this.uses = uses;
    }

    /**
     * Defines the use of the item
     * @param poke - the pokemon for which the item will be used.
     */
    public String use(Pokemon poke){
        if (uses > 0){
            uses--;
        }
        return "";
    }


    protected void setRestore(int health) {
        this.restore = health;
    }

    protected int getRestore() {
        return restore;
    }

    public int getUses() {
        return this.uses;
    }

    public void addUses(int uses) {
        this.uses += uses;
    }

    public void deductUses(int uses) {
        this.uses -= uses;
        if (this.uses <0){
            uses = 0;
        }
    }

    public String getItemName(){
        return itemName;
    }

}
