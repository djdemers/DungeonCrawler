package characters.decorators;

import characters.Character;

/**
 * Decorator that enhances a character's defense due to equipping armor.
 */
public class ArmorDecorator extends CharacterDecorator {
    private int additionalDefense;

    public ArmorDecorator(Character decoratedCharacter, int additionalDefense) {
        super(decoratedCharacter);
        this.additionalDefense = additionalDefense;
    }
    @Override
    public int getDefense() {
        // Add the armor's additional defense to the decorated character's defense
        return super.getDefense() + additionalDefense;
    }

    @Override
    public void unequip() {
        super.setDefense(super.getDefense() - additionalDefense);
    }
}
