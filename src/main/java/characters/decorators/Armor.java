package characters.decorators;

import characters.Character;
import interfaces.Equipable;

/**
 * Represents armor that can be equipped by a character to increase defense.
 * This class extends CharacterDecorator, allowing it to modify character attributes dynamically.
 */
public class Armor extends CharacterDecorator implements Equipable {
    private String itemName;
    private int additionalDefense;
    private int price;

    /**
     * Constructs an Armor object that decorates a character, enhancing its defense.
     *
     * @param name the name of the armor
     * @param decoratedCharacter the character to be decorated
     * @param additionalDefense the additional defense provided by the armor
     * @param price the cost of the armor
     */
    public Armor(String name, Character decoratedCharacter, int additionalDefense, int price) {
        super(decoratedCharacter);
        this.itemName = name;
        this.additionalDefense = additionalDefense;
        this.price = price;
    }

    /**
     * Equips the armor to the character, applying additional defense attributes.
     */
    @Override
    public CharacterDecorator equip(Character character) {
        this.apply();
        System.out.println("equipped " + itemName + " and gained " + additionalDefense + " defense.");
        return this;
    }

    /**
     * Unequips the armor from the character, removing the previously applied defense enhancements.
     */
    @Override
    public void unequip(Character character) {
        this.revert();
        System.out.println("unequips " + itemName);
    }

    /**
     * Applies the defensive enhancement to the character.
     */
    @Override
    public void apply() {
        decoratedCharacter.setDefense(decoratedCharacter.getDefense() + additionalDefense);
    }

    /**
     * Reverts the defensive enhancement from the character.
     */
    @Override
    public void revert() {
        decoratedCharacter.setDefense(decoratedCharacter.getDefense() - additionalDefense);
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the item.
     */
    public String getName() {
        return itemName;
    }

    /**
     * Gets the type of the item.
     *
     * @return the type of the item, which is "Armor".
     */
    @Override
    public String getType() {
        return "Armor";
    }

    /**
     * Gets the bonus provided by the item.
     *
     * @return the additional defense provided by the armor.
     */
    @Override
    public int getBonus() {
        return additionalDefense;
    }

    /**
     * Gets the price of the item.
     *
     * @return the price of the item.
     */
    public int getPrice() {
        return price;
    }
}
