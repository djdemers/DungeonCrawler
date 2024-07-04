package characters;

import characters.skills.ArrowShot;
import characters.skills.MultiShot;

/**
 * Represents the Archer character class in the game.
 * Archers are skilled marksmen with abilities that focus on long-range attacks.
 * They have a balanced mix of speed and attack power, making them effective at hitting targets from a distance.
 */
public class Archer extends Character {

    /**
     * Constructs a new Archer with specified name and race.
     * Archers start with specific base stats modified by their race attributes.
     * They are equipped with unique skills tailored to ranged combat, such as Arrow Shot and Multi Shot.
     *
     * @param name The name of the archer.
     * @param race The race of the archer, influencing their base attributes.
     */
    public Archer(String name, Race race) {
        // Initialize the archer with base stats before applying racial modifiers:
        // Base Health: 80, Base Attack Power: 12, Base Speed: 5, Base Defense: 3, Base Mana: 10
        super(name, race, 80, 12, 5, 3, 10);

        // Add specific skills that enhance the archer's ability to perform in combat:
        addSkill(new ArrowShot());  // A skill for a precise single-target attack.
        addSkill(new MultiShot());  // A skill for hitting multiple targets at once.
    }
}

