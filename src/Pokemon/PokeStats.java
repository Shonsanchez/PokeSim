package Pokemon;

/**
 * Created by Shon on 9/29/2017.
 * This class stores the stats for a pokemon.
 */
public class PokeStats {
    private int healthPoint,attack, defense, spAttack,spDefense,speed,level; //Max stat values
    private int curHp, curA, curD, curSpA, curSpD, curS; //Current Stat values

    public PokeStats(int level,int healthPoint, int attack, int defense, int spAttack, int spDefense, int speed){
        this.level = level;
        this.healthPoint= healthPoint;
        curHp = healthPoint;
        this.attack = attack;
        curA = attack;
        this.defense = defense;
        curD = defense;
        this.spAttack = spAttack;
        curSpA = spAttack;
        this.spDefense = spDefense;
        curSpD = spDefense;
        this.speed = speed;
        curS = speed;
    }

    /**
     * Resets the current stats to the max stats except for health
     * This method is primary used at the end of battles
     */
    public void resetStats(){
        curA = attack;
        curD = defense;
        curSpA = spAttack;
        curSpD = spDefense;
        curS = speed;
    }

    /**
     * Add health to the curHP
     * @param health - the amount of health to be restored.
     */
    public void restoreHealth(int health){
        curHp += health;
        if (curHp > healthPoint)
            curHp = healthPoint;
    }

    /**
     * set the current hp to the healthPoint
     */
    public void resetHealth(){
        curHp = healthPoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    public int getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(int spDefense) {
        this.spDefense = spDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}