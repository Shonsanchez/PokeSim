package PokeS;

/**
 * Created by Shon on 9/26/2017.
 */
public enum Gender {
    MALE,
    FEMALE;

    /**
     * Selects a gender based on integer input
     * @param choice - an int
     * @return - FEMALE if choice = 2 else MALE
     */
    public static Gender getGender(int choice){
        switch (choice){
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            default:
                return MALE;
        }
    }
}
