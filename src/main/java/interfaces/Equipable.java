package interfaces;

import characters.Character;
import characters.decorators.CharacterDecorator;


/**
 * Interface for items that can be equipped by characters in the game.
 * Equipable items can affect character stats or abilities.
 */
public interface Equipable extends Item {
    /**
     * Equip this item onto a character. This usually modifies the character's attributes
     * or abilities in some way.
     * @param character The character onto which the item will be equipped.
     * @return A CharacterDecorator that represents the modifications made to the character.
     */
    CharacterDecorator equip(Character character);

    /**
     * Unequip this item from a character, reversing the effects applied when the item was equipped.
     * @param character The character from which the item will be unequipped.
     */
    void unequip(Character character);

    /**
     * Get the type of the equipable item. This type is used to determine the category of equipment,
     * such as "Sword", "Armor", "Boots", etc.
     * @return A string representing the type of the equipment.
     */
    String getType();

    /**
     * Get the bonus provided by the equipable item. This could be attack power, defense, speed, etc.,
     * depending on the type of equipment.
     * @return An integer value representing the bonus provided by the item.
     */
    int getBonus();
}
