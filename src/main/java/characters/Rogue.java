package characters;

import characters.skills.BackStab;
import characters.skills.PoisonDagger;

/**
 * Represents the Rogue character class in the game.
 * Rogues are agile and stealthy combatants, specializing in quick, decisive attacks that can disable enemies before they can react.
 * This class embodies the essence of stealth and precision, utilizing skills that capitalize on surprise and tactical advantage.
 */
public class Rogue extends Character {

    /**
     * Constructs a new Rogue with specified name and race.
     * Rogues are characterized by their agility, making them excellent for stealth and evasion tactics.
     * This constructor initializes a Rogue with race-adjusted base stats and equips them with skills suited for subterfuge and direct damage.
     *
     * @param name The name of the rogue.
     * @param race The race of the rogue, influencing their base attributes.
     */
    public Rogue(String name, Race race) {
        // Initialize the rogue with base stats before applying racial modifiers:
        // Base Health: 70, Base Attack Power: 8, Base Speed: 20, Base Defense: 2, Base Mana: 10
        super(name, race, 70, 8, 20, 2, 10);

        // Equip the rogue with specialized skills:
        addSkill(new BackStab());  // Enables powerful attacks from behind, dealing increased damage.
        addSkill(new PoisonDagger());  // Inflicts damage over time, weakening enemies gradually.
    }
}

