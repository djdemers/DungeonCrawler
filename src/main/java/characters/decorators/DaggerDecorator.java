package characters.decorators;
import characters.Character;

/**
 * Decorator that enhances a character's attack power and speed by equipping a dagger.
 */
public class DaggerDecorator extends CharacterDecorator {
    private int additionalAttackPower;
    private int additionalSpeed;

    public DaggerDecorator(Character decoratedCharacter, int additionalAttackPower, int additionalSpeed) {
        super(decoratedCharacter);
        this.additionalAttackPower = additionalAttackPower;
        this.additionalSpeed = additionalSpeed;
    }

    @Override
    public int getAttackPower() {
        // Adds additional attack power to the decorated character's attack power
        return super.getAttackPower() + additionalAttackPower;
    }

    @Override
    public int getSpeed() {
        // Adds additional speed to the decorated character's speed
        return super.getSpeed() + additionalSpeed;
    }
    @Override
    public void unequip() {
        super.setAttackPower(super.getAttackPower() - additionalAttackPower);
        super.setSpeed(super.getSpeed() - additionalSpeed);
    }
}
