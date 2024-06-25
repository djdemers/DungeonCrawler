package characters.decorators;
import characters.Character;

/**
 * Decorator that enhances a character's attack power and speed by equipping a dagger.
 */
public class Dagger extends CharacterDecorator {
    private int additionalAttackPower;
    private int additionalSpeed;

    public Dagger(Character decoratedCharacter, int additionalAttackPower, int additionalSpeed) {
        super(decoratedCharacter);
        this.additionalAttackPower = additionalAttackPower;
        this.additionalSpeed = additionalSpeed;
    }
    @Override
    public void apply(Character character){
        character.setAttackPower(character.getAttackPower() + additionalAttackPower);
        character.setSpeed(character.getSpeed() + additionalSpeed);
    }
    @Override
    public void revert(Character character){
        character.setAttackPower(character.getAttackPower() - additionalAttackPower);
        character.setSpeed(character.getSpeed() - additionalSpeed);
    }

}
