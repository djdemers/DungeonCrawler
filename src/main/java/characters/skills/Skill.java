package characters.skills;

import characters.Character;

/**
 * Abstract class representing a generic skill in the game.
 * The SkillManager class handles the application and timing of these skills.
 */
public abstract class Skill {
    protected String name;
    protected String description;
    protected int cooldown; // Turns
    protected int manaCost;
    protected int duration;

    public Skill(String name, String description, int cooldown, int manaCost, int duration) {
        this.name = name;
        this.description = description;
        this.cooldown = cooldown;
        this.manaCost = manaCost;
        this.duration = duration;
    }

    /**
     * Defines how the skill is activated. This method should be called by the SkillManager
     * when the skill is actually used.
     * @param caster The character casting the skill.
     * @param target The target of the skill.
     */
    public abstract void activate(Character caster, Character target);
    public abstract void deactivate(Character caster); // Method to revert effects of the skill

    public boolean hasDuration() {
        return duration > 0;
    }

    public int getDuration() {
        return duration;
    }

    /**
     * Determines if the skill can be used based on the caster's current state.
     * This checks for resource availability and should eventually check for cooldown state
     * managed by the SkillManager.
     *
     * @param caster The character trying to use the skill.
     * @return true if the skill can be used (enough resources).
     */
    public boolean isAvailable(Character caster) {
        return caster.getMana() >= manaCost;
    }

    // Getters for skill attributes
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
}
