package characters.decorators;

import characters.Character;
import interfaces.Equipable;

/**
 * Represents a sword that can be equipped by a character to increase attack power.
 * This class extends CharacterDecorator, allowing it to modify character attributes dynamically.
 */
public class Sword extends CharacterDecorator implements Equipable {
    private String itemName;
    private int attackBoost;
    private int price;

    /**
     * Constructs a Sword object that decorates a character, enhancing its attack power.
     *
     * @param name the name of the sword
     * @param decoratedCharacter the character to be decorated
     * @param attackBoost the additional attack power provided by the sword
     * @param price the cost of the sword
     */
    public Sword(String name, Character decoratedCharacter, int attackBoost, int price) {
        super(decoratedCharacter);
        this.itemName = name;
        this.attackBoost = attackBoost;
        this.price = price;
    }

    /**
     * Equips the sword to the character, applying additional attack power.
     */
    @Override
    public CharacterDecorator equip(Character character) {
        this.apply();
        System.out.println("equipped " + itemName + " and gained " + attackBoost + " attack.");
        return this;
    }

    /**
     * Unequips the sword from the character, removing the previously applied attack enhancements.
     */
    @Override
    public void unequip(Character character) {
        this.revert();
        System.out.println("unequips " + itemName);
    }

    /**
     * Applies the attack power enhancement to the character.
     */
    @Override
    public void apply() {
        decoratedCharacter.setAttackPower(decoratedCharacter.getAttackPower() + attackBoost);
    }

    /**
     * Reverts the attack power enhancement from the character.
     */
    @Override
    public void revert() {
        decoratedCharacter.setAttackPower(decoratedCharacter.getAttackPower() - attackBoost);
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the sword.
     */
    public String getName() {
        return itemName;
    }

    /**
     * Gets the type of the item.
     *
     * @return the type of the item, which is "Sword".
     */
    @Override
    public String getType() {
        return "Sword";
    }

    /**
     * Gets the bonus provided by the item.
     *
     * @return the additional attack power provided by the sword.
     */
    @Override
    public int getBonus() {
        return attackBoost;
    }

    /**
     * Gets the price of the item.
     *
     * @return the price of the sword.
     */
    public int getPrice() {
        return price;
    }
}