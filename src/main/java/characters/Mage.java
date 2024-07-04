package characters;

import characters.skills.Fireball;
import characters.skills.IceSpike;

/**
 * Represents the Mage character class in the game.
 * Mages are powerful spellcasters with abilities focusing on magical attacks.
 * They typically have higher mana and special attack capabilities but lower health and physical defense.
 */
public class Mage extends Character {

    /**
     * Constructs a new Mage with specified name and race.
     * Mages start with specific base stats modified by their race attributes.
     * They are equipped with unique magical skills such as Fireball and Ice Spike.
     *
     * @param name The name of the mage.
     * @param race The race of the mage, influencing their base attributes.
     */
    public Mage(String name, Race race) {
        // Initialize the mage with base stats before applying racial modifiers:
        // Base Health: 60, Base Attack Power: 20, Base Speed: 9, Base Defense: 1, Base Mana: 20
        super(name, race, 60, 20, 9, 1, 20);

        // Add unique skills specific to mages:
        addSkill(new Fireball());
        addSkill(new IceSpike());
    }
}
