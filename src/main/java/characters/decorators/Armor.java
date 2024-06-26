package characters.decorators;

import characters.Character;
import service.Item;

/**
 * Decorator that enhances a character's defense due to equipping armor.
 * Implements the Item interface to integrate with inventory management systems.
 */
public class Armor extends CharacterDecorator implements Item {
    private int additionalDefense;
    private String name;
    private String description;

    /**
     * Constructs an Armor decorator with a specified defense enhancement and item details.
     * @param decoratedCharacter The character to which this armor will be applied.
     * @param additionalDefense The additional defense points this armor provides.
     * @param name The name of the armor.
     * @param description A description of the armor.
     */
    public Armor(Character decoratedCharacter, int additionalDefense, String name, String description) {
        super(decoratedCharacter);
        this.additionalDefense = additionalDefense;
        this.name = name;
        this.description = description;
    }

    /**
     * Applies the armor's defense enhancement to the character. This method
     * increases the character's defense by the amount specified in additionalDefense.
     * @param character The character whose defense is to be increased.
     */
    @Override
    public void apply(Character character) {
        character.setDefense(character.getDefense() + additionalDefense);
    }

    /**
     * Reverts the defense enhancement by subtracting the additional defense
     * from the character's current defense.
     * @param character The character whose defense is to be decreased.
     */
    @Override
    public void revert(Character character) {
        character.setDefense(character.getDefense() - additionalDefense);
    }

    /**
     * Gets the name of the armor.
     * @return A string representing the name of the armor.
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription(){
        return description;
    }
}


