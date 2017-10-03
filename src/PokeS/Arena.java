package PokeS;

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
    private Pokemon currPoke;
    private Pokemon oppPoke;
    Scanner scanner = new Scanner(System.in);
    int choice;



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
            return useMove(move);
        return true;
    }

    private boolean displaySwitch() {
        if (proponent.getNonFaintedPoke().size() > 1){
            System.out.println(proponent.getNonFaintedPoke().size());
            for (Pokemon poke: proponent.getNonFaintedPoke()){
                System.out.println(poke.getName());
            }
        }else
            System.out.println("You don't have any other pokemon that can fight.\n");

        return true;
    }

    private boolean displayBag() {
        if (!proponent.getItemsHeld().isEmpty()){
            for (Item item: proponent.getItemsHeld()){
                int counter = 1;
                System.out.println(counter + ")" + item.getItemName());
                choice = scanner.nextInt(); //need error checking.
            }
        }else {
            System.out.println("Bag is empty.");
        }
        return true;
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

    public boolean selectOption(int option){
        switch (option){
            case 1:
                return displayMoves();
            case 2:
                return displaySwitch();
            case 3:
                return displayBag();
            case 4:
                return displayRun();
            default:
                return true;
        }
    }

    /**
     * Deducts health from the opponent's pokemon based on base dmg of move and
     * forms a string of the amount of dmg done.
     * @return - a String of the amount of dmg dealt.
     */
    public boolean useMove(Move move){

        int dmg = move.calculateDmg(currPoke,oppPoke);
        oppPoke.takeDmg(dmg);
        String result = currPoke.getName() + " did " + dmg + " damage.\n";
        if (oppPoke.isFainted()){
            result += oppPoke.getName() + " Fainted.";
        }else {
            result+= oppPoke.getName()  + " " + oppPoke.getHealth();
        }
        System.out.println(result);
        return !someoneLost();
    }



    /**
     * Creates a string with the list of moves for the selected pokemon.
     * @return - a string with a list of moves for the selected pokemon.
     */
    public String getMoves(){
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
    public String getOptions(){
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
