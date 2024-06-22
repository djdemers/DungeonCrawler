public class SwordDecorator extends CharacterDecorator {
    private int additionalAttackPower = 10;

    public SwordDecorator(Character decoratedCharacter, int additionalAttackPower) {
        super(decoratedCharacter);
        this.additionalAttackPower = additionalAttackPower;
    }

    @Override
    public void attack(Enemy target) {
        // Temporarily boost attack power
        decoratedCharacter.attackPower += additionalAttackPower;
        super.attack(target);
        // Reset attack power after attack
        decoratedCharacter.attackPower -= additionalAttackPower;
    }
}
