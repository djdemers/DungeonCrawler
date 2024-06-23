//Decorator Design Pattern from Structural Patterns

public abstract class CharacterDecorator extends Character {
    protected Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter) {
        super(decoratedCharacter.name, decoratedCharacter.race, decoratedCharacter.health,
                decoratedCharacter.attackPower, decoratedCharacter.speed);
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



