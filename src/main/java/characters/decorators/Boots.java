package characters.decorators;

import characters.Character;
import interfaces.Equipable;

/**
 * Represents boots that can be equipped by a character to increase speed.
 * This class extends CharacterDecorator, allowing it to modify character attributes dynamically.
 */
public class Boots extends CharacterDecorator implements Equipable {
    private String itemName;
    private int additionalSpeed;
    private int price;

    /**
     * Constructs a Boots object that decorates a character, enhancing its speed.
     *
     * @param name the name of the boots
     * @param decoratedCharacter the character to be decorated
     * @param additionalSpeed the additional speed provided by the boots
     * @param price the cost of the boots
     */
    public Boots(String name, Character decoratedCharacter, int additionalSpeed, int price) {
        super(decoratedCharacter);
        this.itemName = name;
        this.additionalSpeed = additionalSpeed;
        this.price = price;
    }

    /**
     * Equips the boots to the character, applying additional speed.
     */
    @Override
    public CharacterDecorator equip(Character character) {
        this.apply();
        System.out.println("equipped " + itemName + " and gained " + additionalSpeed + " speed.");
        return this;
    }

    /**
     * Unequips the boots from the character, removing the previously applied speed enhancements.
     */
    @Override
    public void unequip(Character character) {
        this.revert();
        System.out.println("unequips " + itemName);
    }

    /**
     * Applies the speed enhancement to the character.
     */
    @Override
    public void apply() {
        decoratedCharacter.setSpeed(decoratedCharacter.getSpeed() + additionalSpeed);
    }

    /**
     * Reverts the speed enhancement from the character.
     */
    @Override
    public void revert() {
        decoratedCharacter.setSpeed(decoratedCharacter.getSpeed() - additionalSpeed);
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the boots.
     */
    public String getName() {
        return itemName;
    }

    /**
     * Gets the type of the item.
     *
     * @return the type of the item, which is "Boots".
     */
    @Override
    public String getType() {
        return "Boots";
    }

    /**
     * Gets the bonus provided by the item.
     *
     * @return the additional speed provided by the boots.
     */
    @Override
    public int getBonus() {
        return additionalSpeed;
    }

    /**
     * Gets the price of the item.
     *
     * @return the price of the boots.
     */
    public int getPrice() {
        return price;
    }
}

