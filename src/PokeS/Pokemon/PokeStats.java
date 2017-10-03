package PokeS.Pokemon;

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
     * reduced the pokemon's health
     * @param dmg - the amount of health to deduce from the current health
     */
    public void takedmg(int dmg){
        curHp -= dmg;
    }

    public String getStats(){
        String stats = "";
        stats += "HP: " + healthPoint + " CurHP: " + curHp +
                "\nAttack: " + attack +
                "\nDefense: " + defense +
                "\nSp Attack: " + spAttack +
                "\nSp Defense: " + spDefense +
                "\nSpeed: " + speed;
        return stats;
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

    public int getCurHp() {
        return curHp;
    }

    public void setCurHp(int curHp) {
        this.curHp = curHp;
    }

    public int getCurA() {
        return curA;
    }

    public void setCurA(int curA) {
        this.curA = curA;
    }

    public int getCurD() {
        return curD;
    }

    public void setCurD(int curD) {
        this.curD = curD;
    }

    public int getCurSpA() {
        return curSpA;
    }

    public void setCurSpA(int curSpA) {
        this.curSpA = curSpA;
    }

    public int getCurSpD() {
        return curSpD;
    }

    public void setCurSpD(int curSpD) {
        this.curSpD = curSpD;
    }

    public int getCurS() {
        return curS;
    }

    public void setCurS(int curS) {
        this.curS = curS;
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
