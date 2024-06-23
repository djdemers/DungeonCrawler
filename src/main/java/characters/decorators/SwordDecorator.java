package characters.decorators;

import characters.Character;
import enemies.Enemy;

public class SwordDecorator extends CharacterDecorator {
    private int additionalAttackPower;

    public SwordDecorator(Character decoratedCharacter, int additionalAttackPower) {
        super(decoratedCharacter);
        this.additionalAttackPower = additionalAttackPower;
        this.decoratedCharacter.setAttackPower(decoratedCharacter.getAttackPower() + additionalAttackPower);
    }

    @Override
    public void attackEnemy(Enemy target) {
        super.attackEnemy(target);
    }


    public void removeSword() {
        this.decoratedCharacter.setAttackPower(decoratedCharacter.getAttackPower() - additionalAttackPower);
    }

    public int getAdditionalAttackPower(){
        return additionalAttackPower;
    }
}

