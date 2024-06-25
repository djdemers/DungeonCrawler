package characters.decorators;
import characters.Character;

/**
 * Decorator that enhances a character's attack power due to equipping a sword.
 */
public class Sword extends CharacterDecorator {
    private int additionalAttackPower;

    public Sword(Character decoratedCharacter, int additionalAttackPower) {
        super(decoratedCharacter);
        this.additionalAttackPower = additionalAttackPower;
    }
    @Override
    public void apply(Character character) {
        character.setAttackPower(character.getAttackPower() + additionalAttackPower);
    }

    @Override
    public void revert(Character character) {
        character.setAttackPower(character.getAttackPower() - additionalAttackPower);
    }

}




