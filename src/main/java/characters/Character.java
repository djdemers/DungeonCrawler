package characters;

import enemies.Enemy;
import inventory.Inventory;

/**
 * Represents an abstract character in the game.
 * This class provides a base for creating characters with basic attributes
 * like name, race, health, attack power, and speed, along with common methods
 * that handle character interactions such as attacking and taking damage.
 */
public abstract class Character {

    protected String name;
    protected Race race;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected int speed;
    protected int defense;
    protected int mana;
    protected int maxMana;

    private Inventory inventory;

    /**
     * Constructs a new character with specified attributes and race modifiers.
     *
     * @param name the name of the character
     * @param race the race of the character, which modifies base attributes
     * @param baseHealth the base health of the character before racial modifiers
     * @param baseAttackPower the base attack power of the character before racial modifiers
     * @param baseSpeed the base speed of the character before racial modifiers
     * @param baseDefense the base defense of the character before racial modifiers
     * @param baseMana the base mana of the character before racial modifiers
     */
    public Character(String name, Race race, int baseHealth, int baseAttackPower, int baseSpeed, int baseDefense, int baseMana) {
        this.name = name;
        this.race = race;
        this.health = baseHealth + race.getHealthBonus();
        this.maxHealth = baseHealth + race.getHealthBonus();
        this.attackPower = baseAttackPower + race.getStrengthBonus();
        this.speed = baseSpeed + race.getAgilityBonus();
        this.defense = baseDefense + race.getDefenseBonus();
        this.mana = baseMana + race.getManaBonus();
        this.maxMana = baseMana + race.getManaBonus();
        this.inventory = new Inventory(this);

    }


    /**
     * Displays the character's current stats to the console.
     */
    public void displayStats() {
        // Use getters to ensure all modifications by decorators are reflected
        System.out.println(name + " the " + race.getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Mana: " + getMana());
        System.out.println("Attack: " + getAttackPower());
        System.out.println("Speed " + getSpeed());
        System.out.println(  "Defense: " + getDefense());
    }

    /**
     * Attacks the specified enemy, reducing their health by this character's attack power.
     *
     * @param target the enemy to attack
     */
    public void attackEnemy(Enemy target) {
        int initialDamage = this.getAttackPower();
        int damageDone = initialDamage - target.getDefense();
        target.reduceHealth(initialDamage);
        System.out.println(this.name + " attacks " + target.getName() + " for "
                + damageDone + " damage.");
    }

    /**
     * Handles the damage taken by this character when hit by an enemy.
     *
     * @param target the enemy that hits this character
     */
    public void heroIsHit(Enemy target){
        this.reduceHealth(target.getAttackPower());  // Use reduceHealth to factor in defense
        System.out.println(this.name + " was hit by " + target.getName() + " for " + target.getAttackPower() + " damage.");
    }


    /**
     * Checks if the character is still alive based on their health.
     *
     * @return true if health is greater than 0, otherwise false
     */
    public boolean isAlive() {
        return this.health > 0;
    }

    /**
     * Reduces the character's health by the specified damage amount.
     * Ensures that health does not drop below zero.
     *
     * @param damage the amount of damage to inflict
     */
    public void reduceHealth(int damage) {
        // Use the getter for defense to ensure any overridden behavior is respected
        int damageTaken = Math.max(0, damage - getDefense());
        // Calculate the new health value using getters and setters
        int newHealth = getHealth() - damageTaken;
        // Use the setter to adjust the health and ensure any additional logic in the setter is applied
        setHealth(Math.max(0, newHealth)); // Ensure health does not drop below zero
    }

    // Getter methods with simple Javadoc comments
    /**
     * Returns the name of the character.
     * @return the character's name
     */
    public String getName(){
        return this.name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Returns the current health of the character.
     * @return the character's health
     */
    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }
    public int getMana(){
        return mana;
    }
    public void setMana(int mana){
        this.mana = mana;
    }

    public int getMaxMana(){
        return this.maxMana;
    }

    /**
     * Returns the attack power of the character.
     * @return the character's attack power
     */
    public int getAttackPower(){
        return attackPower;
    }

    /**
     * Sets the attack power of the character.
     * @param attackPower the new attack power
     */
    public void setAttackPower(int attackPower){
        this.attackPower = attackPower;
    }

    /**
     * Returns the speed of the character.
     * @return the character's speed
     */
    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    /**
     * Returns the defense of the character
     * @return the character's defense.
     */
    public int getDefense(){
        return defense;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }
    /**
     * Returns the race of the character.
     * @return the character's race
     */
    public Race getRace() {
        return race;
    }
}

