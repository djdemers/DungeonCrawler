package factories;

import characters.decorators.Armor;
import characters.decorators.Dagger;
import characters.decorators.Sword;
import characters.consumables.HealthPotion;
import service.Item;
import characters.Character;

public class ItemFactory {

    /**
     * Creates an item based solely on type, for items that do not depend on a character.
     * This method is suitable for items like health potions which do not modify character states directly.
     *
     * @param type The type of item to create.
     * @return The created item.
     */
    public static Item getItem(String type) {
        switch (type) {
            case "Health Potion":
                return new HealthPotion("Health Potion", "Restores 50 health", 50);
            default:
                throw new IllegalArgumentException("No such simple item type or type requires additional parameters: " + type);
        }
    }

    /**
     * Creates an item requiring a character, name, description, and a value,
     * such as weapons or armor that directly affect character stats.
     *
     * @param type The type of item to create.
     * @param name The name of the item.
     * @param description The description of the item.
     * @param value The primary value associated with the item (e.g., attack or defense points).
     * @param character The character associated with the item.
     * @return The created item.
     */
    public static Item createItem(String type, String name, String description, int value, Character character) {
        switch (type) {
            case "Sword":
                return new Sword(character, value, name, description);
            case "Armor":
                return new Armor(character, value, name, description);
            case "Dagger":
                return new Dagger(character, value, name, description);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }
}
