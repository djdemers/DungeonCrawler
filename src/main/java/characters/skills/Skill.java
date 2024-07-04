package characters.skills;

import characters.Character;
import enemies.Enemy;

/**
 * Abstract class representing a generic skill in the game.
 * This class provides the foundation for implementing various types of skills that characters can use during combat.
 * Skills may consume mana, have cooldown periods, and can have effects that last for a certain duration.
 */
public abstract class Skill {
    protected String name;           // The name of the skill.
    protected String description;    // A description of what the skill does.
    protected int cooldown;          // The cooldown time in turns before the skill can be used again.
    protected int manaCost;          // The amount of mana required to use the skill.
    protected int duration;          // The duration for which the skill effects last.

    /**
     * Constructs a new skill with specified characteristics.
     *
     * @param name        The name of the skill.
     * @param description A brief description of the skill's effects.
     * @param cooldown    The number of turns required to wait before the skill can be used again.
     * @param manaCost    The amount of mana required to activate the skill.
     * @param duration    The number of turns the skill's effects last.
     */
    public Skill(String name, String description, int cooldown, int manaCost, int duration) {
        this.name = name;
        this.description = description;
        this.cooldown = cooldown;
        this.manaCost = manaCost;
        this.duration = duration;
    }

    /**
     * Activates the skill, applying its effects to the target enemy. This method must be implemented to define
     * the specific attack mechanics of the skill.
     *
     * @param caster The character casting the skill.
     * @param target The enemy targeted by the skill.
     */
    public abstract void activateAttack(Character caster, Enemy target);

    /**
     * Deactivates the skill, typically reversing any ongoing effects it may have applied.
     *
     * @param caster The character who used the skill, who may still be under its effects.
     */
    public abstract void deactivate(Character caster);

    /**
     * Checks if the skill has a duration effect beyond its immediate use.
     *
     * @return true if the skill has a duration, false otherwise.
     */
    public boolean hasDuration() {
        return duration > 0;
    }

    /**
     * Checks if the skill is available for use, based on the caster's current mana.
     *
     * @param caster The character attempting to use the skill.
     * @return true if the caster has enough mana to use the skill, false otherwise.
     */
    public boolean isAvailable(Character caster) {
        return caster.getMana() >= manaCost;
    }

    /**
     * Consumes the required amount of mana from the caster's mana pool to use the skill.
     *
     * @param caster The character using the skill.
     */
    public void consumeMana(Character caster) {
        if (isAvailable(caster)) {
            caster.setMana(caster.getMana() - manaCost);
        } else {
            throw new IllegalStateException("Not enough mana to use " + getName() + ".");
        }
    }

    // Getters for the skill's properties
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getDuration() {
        return duration;
    }
}
