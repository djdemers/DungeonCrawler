package characters.decorators;
import characters.Character;

/**
 * Decorator that enhances a character's attack power due to equipping a sword.
 */
public class SwordDecorator extends CharacterDecorator {
    private int additionalAttackPower;

    public SwordDecorator(Character decoratedCharacter, int additionalAttackPower) {
        super(decoratedCharacter);
        this.additionalAttackPower = additionalAttackPower;
    }
    @Override
    public int getAttackPower() {
        return super.getAttackPower() + additionalAttackPower;
    }

    @Override
    public void unequip() {
        super.setAttackPower(super.getAttackPower() - additionalAttackPower);
    }

}




