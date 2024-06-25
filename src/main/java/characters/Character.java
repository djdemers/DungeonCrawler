package characters;
import characters.decorators.CharacterDecorator;
import enemies.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
    protected int attackPower;
    protected int speed;
    protected int defense;

    private List<CharacterDecorator> decorators = new ArrayList<>();

    /**
     * Constructs a new character with specified attributes and race modifiers.
     *
     * @param name the name of the character
     * @param race the race of the character, which modifies base attributes
     * @param baseHealth the base health of the character before racial modifiers
     * @param baseAttackPower the base attack power of the character before racial modifiers
     * @param baseSpeed the base speed of the character before racial modifiers
     */
    public Character(String name, Race race, int baseHealth, int baseAttackPower, int baseSpeed, int baseDefense) {
        this.name = name;
        this.race = race;
        this.health = baseHealth + race.getHealthBonus();
        this.attackPower = baseAttackPower + race.getStrengthBonus();
        this.speed = baseSpeed + race.getAgilityBonus();
        this.defense = baseDefense + race.getDefenseBonus();
    }

    /**
     * Equips a decorator to this character, applying its effects.
     * The method adds the decorator to the character's list of active decorators
     * and applies its effects to the character's attributes.
     *
     * @param decorator The decorator to be equipped, which will modify the character's attributes.
     */
    public void equipDecorator(CharacterDecorator decorator) {
        decorators.add(decorator);
        decorator.apply(this);
    }

    /**
     * Unequip a decorator of the specified type from this character, reverting its effects.
     * This method searches for the first decorator of the specified type in the list of active decorators,
     * reverts its effects, and then removes it from the list.
     *
     * @param decoratorType The class type of the decorator to be unequipped.
     *        Only the first instance of this type is unequipped.
     */
    public void unequipDecorator(Class<? extends CharacterDecorator> decoratorType) {
        decorators.stream()
                .filter(decoratorType::isInstance)
                .findFirst()
                .ifPresent(decorator -> {
                    decorator.revert(this);
                    decorators.remove(decorator);
                });
    }

    /**
     * Attempts to equip a new decorator, replacing an existing one of the same type if the new one is stronger.
     * This method checks for an existing decorator of the same class as the new decorator.
     * If an existing decorator is found and the new decorator is determined to be stronger,
     * the old decorator is unequipped and the new one is equipped. If no decorator of the same type is
     * currently equipped, the new one is equipped directly.
     *
     * @param newDecorator The new decorator that is being considered for equipping.
     */
    public void attemptToEquipDecorator(CharacterDecorator newDecorator) {
        Optional<CharacterDecorator> existing = decorators.stream()
                .filter(d -> d.getClass().equals(newDecorator.getClass()))
                .findFirst();

        if (existing.isPresent()) {
            // Let's say you decide based on a simple rule: replace if new item is stronger
            if (newDecorator.getAttackPower() > existing.get().getAttackPower()) {
                unequipDecorator(existing.get().getClass());
                equipDecorator(newDecorator);
            } else {
                System.out.println("Kept the existing " + existing.get().getClass().getSimpleName());
            }
        } else {
            equipDecorator(newDecorator);
        }
    }

    /**
     * Displays the character's current stats to the console.
     */
    public void displayStats() {
        // Use getters to ensure all modifications by decorators are reflected
        System.out.println(name + " the " + race.getName() +
                " Health: " + getHealth() +
                " Attack Power: " + getAttackPower() +
                " Speed: " + getSpeed() +
                " Defense: " + getDefense());
        decorators.forEach(d -> System.out.println("Equipped with: " + d.getClass().getSimpleName()));
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

