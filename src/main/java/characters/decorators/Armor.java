package characters.decorators;

import characters.Character;

/**
 * Decorator that enhances a character's defense due to equipping armor.
 */
public class Armor extends CharacterDecorator {
    private int additionalDefense;
    public Armor(Character decoratedCharacter, int additionalDefense) {
        super(decoratedCharacter);
        this.additionalDefense = additionalDefense;
    }
    @Override
    public void apply(Character character) {
        character.setDefense(character.getDefense() + additionalDefense);
    }
    @Override
    public void revert(Character character) {
        character.setDefense(character.getDefense() - additionalDefense);
    }
}
