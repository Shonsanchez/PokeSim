package PokeS;

import PokeS.Items.Item;
import PokeS.Pokemon.Pokemon;
import com.sun.org.apache.regexp.internal.RE;

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
     * Loops through a list of Items and adds them to the this.items ArrayList,
     * checks if the item already exists in the bad, if so increments the uses
     * of the item instead of adding the item.
     * @param items - the items to add.
     */
    public void addItem(Item... items){
        for (Item item: items){
            if (this.items.contains(item)) {
                this.items.get(this.items.indexOf(item)).addUses(item.getUses());
            } else {
                this.items.add(item);
            }
        }
    }

    /**
     * Triggers an item's use method on the itemIndex in the items ArrayList.
     * @param i - the index of the item to be used
     * @param pokemon - the pokemon which will be affected.
     */
    public String useItem(int i, Pokemon pokemon) {
        if (i >= items.size())
            return "";
        String result = items.get(i).use(pokemon);
        updateItemIndex(i);
        return result;
    }

    /**
     * Checks if the uses of the item in index i of items is less than 1, if so
     * deletes the item.
     * @param i - the index of the item.
     * @return - if the has been removed.
     */
    public boolean updateItemIndex(int i) {
        if (items.get(i).getUses() < 1){ //checks if there are any item uses left
            items.remove(i);
            return true;
        }
        return false;
    }

    public ArrayList<Item> getItems() {
        return items;
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

    /**
     * Determines if the bag is empty
     * @return - true if the bag is empty else false
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

}
