package characters;

import characters.skills.Skill;
import characters.skills.SkillManager;
import enemies.*;
import enemies.effects.Effect;
import inventory.Inventory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
    protected List<Skill> skills;
    private SkillManager skillManager;
    private List<Effect> activeEffects = new ArrayList<>();

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
        this.skills = new ArrayList<>();
        this.skillManager = new SkillManager();

    }

    /**
     * Displays the character's current stats to the console.
     */
    public void displayStats() {
        System.out.println("STATS:");
        System.out.println(name + " the " + race.getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Mana: " + getMana());
        System.out.println("Attack: " + getAttackPower());
        System.out.println("Speed " + getSpeed());
        System.out.println("Defense: " + getDefense());
    }

    /**
     * Attacks an enemy character, calculating damage based on the character's attack power and the enemy's defense.
     * This method showcases how different character classes can implement varied damage mechanics based on their unique attributes.
     *
     * @param enemy the enemy to attack
     */
    public void attackEnemy(Enemy enemy) {
        int initialAttack = getAttackPower();
        int damageReduction = enemy.getDefense();
        int effectiveDamage = Math.max(1, initialAttack - damageReduction);

        System.out.println("Hero attack power: " + initialAttack);
        System.out.println("Enemy defense: " + damageReduction);
        System.out.println("Effective damage on enemy: " + effectiveDamage);
        enemy.reduceEnemyHealth(effectiveDamage);
        System.out.println("Enemy takes " + effectiveDamage + " damage, health now " + enemy.getHealth());
    }

    /**
     * Reduces the character's health by the specified damage amount, ensuring health does not drop below zero.
     * This method is critical for handling combat dynamics and can be affected by character class-specific defenses or skills.
     *
     * @param damage the damage amount to subtract from health
     */
    public void reduceHeroHealth(int damage) {
        System.out.println(this.getName() + " original health: " + this.getHealth());
        System.out.println(this.getName() + " defense considered: " + this.getDefense() + ", incoming damage: " + damage);

        int damageTaken = Math.max(1, damage);  // Already calculated in attackHero, no need to subtract defense again
        System.out.println(this.getName() + " damage taken after defense: " + damageTaken);

        int newHealth = Math.max(0, this.getHealth() - damageTaken);
        this.setHealth(newHealth);

        System.out.println(this.getName() + " new health after damage: " + this.getHealth());
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
     * Returns the name of the character.
     * @return the character's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the inventory of the character.
     * @return the character's inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Returns the current health of the character.
     * @return the character's health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Sets the health of the character.
     * @param health the new attack power
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Returns the maximum health of the character.
     * @return maxHealth
     */
    public int getMaxHealth() {
        return this.maxHealth;
    }

    /**
     * Returns the mana of the character.
     * @return mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * Sets the mana of the character.
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * Returns the maximum mana of the character.
     * @return maxHealth
     */
    public int getMaxMana() {
        return this.maxMana;
    }

    /**
     * Returns the attack power of the character.
     * @return the character's attack power
     */
    public int getAttackPower() {
        return attackPower;
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
        return speed;
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
        return defense;
    }

    /**
     * Sets the defense of the character.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Returns the race of the character.
     * @return the character's race
     */
    public Race getRace() {
        return race;
    }

    /**
     * Adds a skill to the character's skill set.
     * This method allows the character to learn a new skill, making it available for use in combat.
     *
     * @param skill The skill to be added to the character.
     */
    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    /**
     * Retrieves the list of skills that the character currently possesses.
     * This method provides access to the character's complete set of skills.
     *
     * @return A list containing all the skills of the character.
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * Checks if the character has a specific skill based on its name.
     * This method is used to verify whether the character has learned a particular skill.
     *
     * @param skillName The name of the skill to check for.
     * @return true if the character has the skill, false otherwise.
     */
    public boolean hasSkill(String skillName) {
        return skills.stream().anyMatch(s -> s.getName().equals(skillName));
    }

    /**
     * Attempts to use a random skill from the character's skill set against an enemy.
     * This method randomly selects a skill and tries to activate it if conditions allow.
     *
     * @param target The enemy to target with the skill.
     * @return true if the skill was successfully used, false if no skill was used.
     */
    public boolean useRandomSkill(Enemy target) {
        if (skills.isEmpty()) {
            System.out.println(name + " has no skills to use.");
            return false;
        }
        Random rand = new Random();
        Skill skill = skills.get(rand.nextInt(skills.size()));
        if (skillManager.activateSkill(skill, this, target)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a temporary effect to the character.
     * This method allows the character to receive temporary modifications or boosts,
     * which can affect combat or other interactions.
     *
     * @param effect The temporary effect to add to the character.
     */
    public void addEffect(Effect effect) {
        activeEffects.add(effect);
    }

    /**
     * Displays all the skills the character has in a readable format.
     * This method is particularly useful for providing players with information about
     * the abilities their character can use.
     */
    public void displaySkills() {
        System.out.println(name + "'s SKILLS:");
        for (Skill skill : skills) {
            System.out.println("- " + skill.getName() + ": " + skill.getDescription());
        }
    }

    /**
     * Updates all active effects on the character. This should be called every turn.
     * Decreases the duration of each effect and removes it if expired.
     */
    public void updateTemporaryEffects() {
        Iterator<Effect> it = activeEffects.iterator();
        while (it.hasNext()) {
            Effect effect = it.next();
            effect.decreaseDuration();  // Decrease duration by one.
            if (effect.isExpired()) {
                effect.removeEffect(this);  // Perform any cleanup necessary when the effect expires.
                it.remove();  // Remove the effect from the list.
            }
        }
    }
}