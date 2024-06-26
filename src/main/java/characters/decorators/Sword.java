package characters.decorators;

import characters.Character;
import service.Item;

/**
 * Decorator that enhances a character's attack power due to equipping a sword.
 */
public class Sword extends CharacterDecorator implements Item {
    private int additionalAttackPower;
    private String name;
    private String description;

    public Sword(Character decoratedCharacter, int additionalAttackPower, String name, String description) {
        super(decoratedCharacter);
        this.additionalAttackPower = additionalAttackPower;
        this.name = name;
        this.description = description;
    }
    @Override
    public void apply(Character character) {
        character.setAttackPower(character.getAttackPower() + additionalAttackPower);
    }

    @Override
    public void revert(Character character) {
        character.setAttackPower(character.getAttackPower() - additionalAttackPower);
    }

    /**
     * Gets the name of the sword.
     * @return A string representing the name of the sword.
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




