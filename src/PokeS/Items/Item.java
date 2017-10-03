package PokeS.Items;

/**
 * Created by Shon on 10/2/2017.
 */
public abstract class Item {
    private int uses;
    private String itemName;

    public Item(String name, int uses){
        this.itemName = name;
        this.uses = uses;
    }

    public void use(){

    }
    public int getUses() {
        return this.uses;
    }

    public void addUses(int uses) {
        this.uses += uses;
    }

    public String getItemName(){
        return itemName;
    }

}
