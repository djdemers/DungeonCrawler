package characters.decorators;//Decorator Design Pattern from Structural Patterns

import characters.Character;
import enemies.Enemy;

public abstract class CharacterDecorator extends Character {
    protected Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter) {
        super(decoratedCharacter.getName(), decoratedCharacter.getRace(), decoratedCharacter.getHealth(),
                decoratedCharacter.getAttackPower(), decoratedCharacter.getSpeed());
        this.decoratedCharacter = decoratedCharacter;
    }

    @Override
    public void displayStats() {
        decoratedCharacter.displayStats();
    }

    @Override
    public void attackEnemy(Enemy target) {
        decoratedCharacter.attackEnemy(target);
    }

    @Override
    public void reduceHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}



