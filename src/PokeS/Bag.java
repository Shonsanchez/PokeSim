package PokeS;

import PokeS.Items.Item;

import java.util.ArrayList;

/**
 * Created by Shon on 10/6/2017.
 */
public class Bag {
    private ArrayList<Item> items = new ArrayList<>();
    private int counter = 1;

    public Bag(Item... items){
        addItem(items);
    }

    /**
     * Loops through a list of Items and adds them to the this.items ArrayList
     * @param items - the items to add.
     */
    public void addItem(Item... items){
        for (Item item: items){
            this.items.add(item);
        }
    }

    /**
     * Loops through the array of items and creates list representation of items in a string.
     * @return -  string with a list representation of items.
     */
    public String itemList(){
        String result = "";
        counter = 1;
        for (Item item : items) {
            result+= counter++ +") " + item.getItemName() +"(" + item.getUses() + "use(s) available) \n";
        }
        return result;
    }
    
}
