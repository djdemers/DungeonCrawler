public class SwordDecorator extends CharacterDecorator {
    private int additionalAttackPower;

    public SwordDecorator(Character decoratedCharacter, int additionalAttackPower) {
        super(decoratedCharacter);
        this.additionalAttackPower = additionalAttackPower;
        this.decoratedCharacter.attackPower += additionalAttackPower;
    }

    @Override
    public void attackEnemy(Enemy target) {
        super.attackEnemy(target);
    }


    public void removeSword() {
        this.decoratedCharacter.attackPower -= additionalAttackPower; // Remove the attack bonus if the sword is unequipped
    }
}

