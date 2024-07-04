package enemies;

import characters.Character;

/**
 * Represents a Dragon enemy in the game.
 * Dragons are formidable opponents with high health, significant attack power, and special abilities.
 */
public class Dragon extends Enemy {

    /**
     * Constructs a new Dragon with predefined attributes.
     * Dragons have a high health pool and attack power, making them a challenging boss enemy.
     */
    public Dragon() {
        super("Dragon", 90, 20, 5, 0);
    }

    /**
     * Performs a fire breath attack on a character.
     * This special attack deals significant fire damage to the target, demonstrating the Dragon's powerful elemental abilities.
     *
     * @param target the character that the Dragon is attacking
     */
    public void fireBreath(Character target) {
        int fireDamage = 60;  // Damage value for the fire breath attack
        target.reduceHeroHealth(fireDamage);  // Applying the damage to the hero
        System.out.println("The dragon breathes fire, causing " + fireDamage + " damage to " + target.getName());
    }
}
