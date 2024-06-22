public class SwordDecorator extends CharacterDecorator {
    private int additionalAttackPower;

    public SwordDecorator(Character decoratedCharacter, int additionalAttackPower) {
        super(decoratedCharacter);
        this.additionalAttackPower = additionalAttackPower;
    }

    @Override
    public void attackEnemy(Enemy target) {
        // Temporarily boost attack power
        decoratedCharacter.attackPower += additionalAttackPower;
        super.attackEnemy(target);
        // Reset attack power after attack
        //decoratedCharacter.attackPower -= additionalAttackPower;
    }
}
