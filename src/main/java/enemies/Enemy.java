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
     * @param defense the defense of the enemy
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
        System.out.println(getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Attack: " + getAttackPower());
        System.out.println("Speed " + getSpeed());
        System.out.println("Defense: " + getDefense());
    }

    /**
     * Attacks the hero character, calculating damage based on the character's attack power and the enemy's defense.
     * This method showcases how different character classes can implement varied damage mechanics based on their unique attributes.
     *
     * @param hero the target to attack
     */
    public void attackHero(Character hero) {
        int initialAttack = getAttackPower();
        int damageReduction = hero.getDefense();
        int effectiveDamage = Math.max(1, initialAttack - damageReduction);

        System.out.println("Enemy attack power: " + initialAttack);
        System.out.println("Hero defense: " + damageReduction);
        System.out.println("Effective damage on hero: " + effectiveDamage);
        hero.reduceHeroHealth(effectiveDamage);
        System.out.println("Hero takes " + effectiveDamage + " damage, health now " + hero.getHealth());
    }


    /**
     * Reduces the enemies health by the specified damage amount, ensuring health does not drop below zero.
     * This method is critical for handling combat dynamics and can be affected by character class-specific defenses or skills.
     *
     * @param damage the damage amount to subtract from health
     */
    public void reduceEnemyHealth(int damage) {
        System.out.println(this.getName() + " original health: " + this.getHealth());
        System.out.println(this.getName() + " defense considered: " + this.getDefense() + ", incoming damage: " + damage);

        int damageTaken = Math.max(1, damage);
        System.out.println(this.getName() + " damage taken after defense: " + damageTaken);

        int newHealth = Math.max(0, this.getHealth() - damageTaken);
        this.setHealth(newHealth);

        System.out.println(this.getName() + " new health after damage: " + this.getHealth());
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
     * Returns the name of the enemy.
     * @return the enemies name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the health of the enemy.
     * @param health the new attack power
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Returns the current health of the enemy.
     * @return the character's health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Returns the attack power of the character.
     * @return the character's attack power
     */
    public int getAttackPower() {
        return this.attackPower;
    }

    /**
     * Sets the attack power of the character.
     */
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    /**
     * Returns the speed of the character.
     * @return the character's speed
     */
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Sets the speed of the character.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Returns the defense of the character.
     * @return the character's defense.
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * Sets the defense of the character.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }
}

