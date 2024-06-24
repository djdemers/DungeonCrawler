package enemies;

import characters.Character;

/**
 * Represents an abstract enemy in the game.
 * This class provides the base functionality for all enemies, including their attributes and methods
 * for interaction such as attacking and being attacked.
 */
public abstract class Enemy {
    protected String name;
    protected int health;
    protected int attackPower;
    protected int speed;
    protected int defense;

    /**
     * Constructs an enemy with specified attributes.
     *
     * @param name the name of the enemy
     * @param health the initial health of the enemy
     * @param attackPower the attack power of the enemy
     * @param speed the speed of the enemy
     */
    public Enemy(String name, int health, int attackPower, int speed, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.speed = speed;
        this.defense = defense;
    }

    /**
     * Displays the current stats of the enemy.
     */
    public void displayStats() {
        System.out.println(name + " Health: " + health + " Attack Power: "
                + attackPower + " Speed: " + speed + "Defense: " + defense);

    }

    /**
     * Reduces the enemy's health by the attack power of the attacking character.
     * Prints the outcome of the attack.
     *
     * @param target the character attacking this enemy
     */
    public void enemyIsHit(Character target) {
        this.health -= target.getAttackPower();
        System.out.println(this.name + " was hit by " + target.getName() + " for " + target.getAttackPower());
    }

    /**
     * Attacks a character, reducing their health by this enemy's attack power.
     * Prints the details of the attack.
     *
     * @param target the character being attacked by this enemy
     */
    public void attackHero(Character target) {
        int damageDone = this.getAttackPower() - target.getDefense();
        target.reduceHealth(this.getAttackPower());
        System.out.println(this.name + " attacks " + target.getName() + " for "
                + damageDone + " damage.");
    }

    /**
     * Checks if the enemy is still alive.
     *
     * @return true if the enemy's health is above zero, false otherwise
     */
    public boolean isAlive() {
        return this.health > 0;
    }

    /**
     * Reduces the health of the enemy by a specified damage amount.
     * Ensures that health does not drop below zero.
     *
     * @param damage the amount of damage inflicted on the enemy
     */
    public void reduceHealth(int damage) {
        int damageTaken = Math.max(0, damage - this.defense);  // Damage reduced by defense, but not below 0
        this.health -= damageTaken;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public int getSpeed(){
        return speed;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
}

