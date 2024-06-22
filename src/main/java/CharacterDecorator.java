public abstract class CharacterDecorator extends Character {
    protected Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter) {
        super(decoratedCharacter.name, decoratedCharacter.health,
                decoratedCharacter.attackPower);
        this.decoratedCharacter = decoratedCharacter;
    }

    @Override
    public void displayStats() {
        decoratedCharacter.displayStats();
    }

    @Override
    public void attack(Enemy target) {
        decoratedCharacter.attack(target);
    }

    @Override
    public void reduceHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}



