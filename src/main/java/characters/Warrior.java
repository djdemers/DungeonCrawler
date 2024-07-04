package characters;

import characters.skills.Rage;
import characters.skills.ShieldBash;

/**
 * Represents the Warrior character class in the game.
 * Warriors are robust and resilient combatants known for their ability to withstand significant damage and lead charges into enemy lines.
 * This class is designed for players who prefer a straightforward combat style focused on strength and durability.
 */
public class Warrior extends Character {

    /**
     * Constructs a new Warrior with specified name and race.
     * Warriors excel in direct combat, leveraging their enhanced health and defensive capabilities.
     * This constructor initializes a Warrior with race-adjusted base stats and equips them with combat-oriented skills.
     *
     * @param name The name of the warrior.
     * @param race The race of the warrior, influencing their base attributes and providing unique advantages.
     */
    public Warrior(String name, Race race) {
        // Initialize the warrior with base stats before applying racial modifiers:
        // Base Health: 80, Base Attack Power: 10, Base Speed: 5, Base Defense: 5, Base Mana: 10
        super(name, race, 80, 10, 5, 5, 10);

        // Equip the warrior with skills that enhance their combat effectiveness:
        addSkill(new Rage());  // Temporarily boosts the warrior's attack power, enhancing damage output.
        addSkill(new ShieldBash());  // Provides a powerful attack that can also stun opponents, disrupting their actions.
    }
}
