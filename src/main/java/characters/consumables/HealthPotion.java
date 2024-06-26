package characters.consumables;

import characters.Character;
import service.Item;

/**
 * Represents a health potion that can be used by a character to restore health.
 * This potion ensures that the character's health does not exceed their maximum allowable health.
 */
public class HealthPotion extends Consumable implements Item {
    private int healingAmount;

    /**
     * Constructs a new Health Potion with a specified name, description, and healing amount.
     *
     * @param name The name of the health potion.
     * @param description A brief description of the health potion's effects.
     * @param healingAmount The amount of health this potion will restore when used.
     */
    public HealthPotion(String name, String description, int healingAmount) {
        super(name, description);
        this.healingAmount = healingAmount;
    }

    /**
     * Uses the potion on a character, restoring a specified amount of health,
     * without exceeding the character's maximum health.
     *
     * @param character The character on whom the potion is used.
     */
    @Override
    public void use(Character character) {
        int originalHealth = character.getHealth(); // Store the original health before healing
        int newHealth = Math.min(character.getHealth() + healingAmount, character.getMaxHealth()); // Calculate new health without exceeding max
        character.setHealth(newHealth); // Set the new health

        int actualHealing = newHealth - originalHealth; // Calculate the actual amount of health restored
        System.out.println(character.getName() + " uses " + name + " and restores " + actualHealing + " health points.");
        // Remove this consumable from the inventory after use
    }

    /**
     * Returns the name of the health potion.
     *
     * @return The name of the potion.
     */
    public String getName(){
        return super.name;
    }

    /**
     * Returns the description of the health potion.
     *
     * @return The description of the potion.
     */
    @Override
    public String getDescription(){
        return description;
    }
}


