package PokeS;

import java.util.concurrent.ThreadLocalRandom;
import PokeS.Items.Item;
import PokeS.Moves.Move;
import PokeS.Pokemon.Pokemon;

import java.util.Scanner;

/**
 * Created by Shon on 9/30/2017.
 * Class used to have pokemon battle each other.
 * Tracks attack priorities, if pokemon fainted and in charge of checking if the trainers involved have
 * any remaining pokemon
 */
public class Arena {
    private Trainer proponent;
    private Trainer opponent;
    private Pokemon currPoke; //Current Pokemon - the Proponent's Pokemon
    private Pokemon oppPoke;
    private Scanner scanner = new Scanner(System.in);
    private int choice;

    /**
     * Constructor that takes in two trainers.
     * @param proponent - the one being fought
     * @param opponent - the opponent
     */
    protected Arena(Trainer proponent, Trainer opponent){
        this.proponent = proponent;
        this.opponent = opponent;
        currPoke = proponent.getFirstNonFaintedPoke();
        oppPoke = opponent.getFirstNonFaintedPoke();
    }

    /**
     * Displays the main menu of the battle and handles options inserted.
     * Determines if either trainer has any non fainted pokemons.
     * @return - returns false if someoneLost is true or if the proponent forfeits else true.
     */
    private boolean displayOptions() {
        System.out.println(getOptions());
        choice = scanner.nextInt();
        return selectOption(choice);
    }


    private boolean displayMoves() {
        Move move;
        System.out.printf(getMoves());
        choice = scanner.nextInt();
        if ((move = currPoke.getMove(choice-1))!=null)
            return doBattle(move);
        return true; //Both trainers are able to battle
    }

    private boolean displaySwitch() {
        if (proponent.getNonFaintedPoke().size() > 1){
            doSwitch();
        }else
            System.out.println("You don't have any other pokemon that can fight.\n");
        return true;
    }

    //if switch occurs do dmg to pokemon.
    //Work on this some more later on
    private void doSwitch(){
        System.out.println(getNonFaintedPokemon());
        choice = scanner.nextInt();
        Pokemon prevPoke = currPoke;
        currPoke = proponent.getNonFaintedPoke().get(choice-1);
        System.out.println(prevPoke.getName() + " has been switched out for " + currPoke.getName());
    }

    /**
     * Forms a list of nonFainted pokemon
     * @return - a string of nonFainted pokemon
     */
    private String getNonFaintedPokemon() {
        String result = "";
        int counter = 1;
        for (Pokemon poke: proponent.getNonFaintedPoke()){
            result+= counter++ + ") " + poke.getName() + "\n";
        }
        return result;
    }

    /**
     * Checks if the bag is empty. If not displays the items within the bag
     * @return - if both trainers are able to battle
     */
    private boolean displayBag() {
        if (!proponent.isBagEmpty()){
            System.out.println(getBagItems());
        }else {
            System.out.println("Bag is empty.");
        }
        System.out.println("");
        return true;
    }


    /**
     * Displays the items within the proponent's bag. Proponent selects the
     * index of the item he wants to use.
     * @return - a string of the effects of the items used.
     */
    private String getBagItems() {
        System.out.println("Items in bag");
        for (Item item: proponent.getItemsHeld()){
            int counter = 1;
            System.out.println(counter + ")" + item.getItemName());
        }
        choice = scanner.nextInt(); //need error checking.
        return (proponent.useItem(choice - 1, currPoke));
    }

    private boolean displayRun() {
        System.out.println("Are you sure? \n1)No, 2)Yes");
        choice = scanner.nextInt();
        switch (choice){
            case 1:
                return true;
            case 2:
                System.out.println("You have surrendered.");
                return false;
            default:
                return true;
        }
    }

    /**
     * Performs action depending on the option chosen
     * @param option - the option number
     * @return - if both trainers are able to continue battle
     */
    private boolean selectOption(int option){
        switch (option){
            case 1:
                return displayMoves();
            case 2:
                return displaySwitch(); //Needs Work
            case 3:
                return displayBag();//Needs work
            case 4:
                return displayRun();
            default:
                return true;
        }
    }


    //Update DocString
    /**
     * Deducts health from the opponent's pokemon based on base dmg of move
     * forms a string of the amount of dmg done.
     */
    private void useMove(Move move, Pokemon attacker, Pokemon defender){
        int dmg = move.calculateDmg(attacker, defender);
        defender.takeDmg(dmg);
        System.out.println(attacker.getName() + " used " + move.getMoveName());
        System.out.println(attacker.getName() + " did " + dmg + " damage to " + defender.getName() + ".");
        if (defender.isFainted()){
            System.out.println(defender.getName() + " Fainted.\n");
        }else {
            System.out.println(defender.getName()  + " " + defender.getHealth() + ".\n");
        }

    }

    /**
     * Makes the opponent attack first
     * @param move - the move of the current Pokemon.
     */
    private void oppAttackFirst(Move move) {
        oppMove();
        if(currPoke.getCurrentHealth() < 0){
            return;
        }
        useMove(move,currPoke,oppPoke);
    }

    /**
     * Makes the current pokemon attack first.
     * @param move - the move of the current Pokemon.
     */
    private void curAttackFirst(Move move) {
        useMove(move,currPoke,oppPoke);
        if (oppPoke.getCurrentHealth() < 0){
            return;
        }
        oppMove();
    }

    /**
     * Makes two pokemon battle, checks for speed to determine who makes the first move.
     * @param move - the move to be used by the current pokemon
     * @return - if both trainers are still able to continue battle
     */
    private boolean doBattle(Move move) {
        float speedRatio = currPoke.speedRatio(oppPoke);
        if (speedRatio > 1){ // the currPoke is faster than oppPoke
            curAttackFirst(move);
        }else if(speedRatio < 1){// oppPoke is faster than currPoke
            oppAttackFirst(move);
        } else{ // currPoke and oppPoke have the same speed.
            if (ThreadLocalRandom.current().nextInt(0,2) == 0){
                curAttackFirst(move);
            }else {
                oppAttackFirst(move);
            }
        }
        return !someoneLost();
    }
    /**
     * Handles the action of the opponent;
     */
    private void oppMove(){
        Move move = null;
        while (move == null) {
            choice = ThreadLocalRandom.current().nextInt(Move.getMinChoice(),Move.getMaxChoice());
            move = oppPoke.getMove(choice - 1);
        }
        useMove(move, oppPoke, currPoke);
    }

    /**
     * Creates a string with the list of moves for the selected pokemon.
     * @return - a string with a list of moves for the selected pokemon.
     */
    private String getMoves(){
        String result = "";
        int cnt = 1;
        for(Move move: currPoke.getMoveSet()){
            result += cnt++ + ") " + move.getMoveName() + "\n";
        }
        return result;
    }

    /**
     * Forms a string with the beginning options to a battle.
     * @return - a string with options.
     */
    private String getOptions(){
        return "1)Attack   2)Switch\n3)Bag      4)Run";
    }

    /**
     * Checks if either trainer has no non fainted pokemon.
     * @return - if either trainer has no more non fainted pokemon.
     */
    private boolean someoneLost(){
        return !proponent.hasNonFaintedPoke() || !opponent.hasNonFaintedPoke();
    }

    /**
     * Begins the battle between the two trainers. Returns if the proponent won the battle.
     * Who ever has no non fainted pokemon loses.
     * @return - if the proponent won the battle true, else false.
     */
    public boolean startBattle(){
        while(displayOptions());
        return proponent.hasNonFaintedPoke();
    }


}
