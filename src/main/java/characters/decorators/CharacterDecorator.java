package characters.decorators;
import characters.Character;
import enemies.Enemy;

/**
 * Abstract decorator for character objects to extend or modify their behavior dynamically.
 * This class provides a framework for adding additional capabilities or modifying existing ones.
 */
public abstract class CharacterDecorator extends Character {
    protected Character decoratedCharacter;

    /**
     * Initializes a new CharacterDecorator that wraps a given Character object.
     *
     * @param decoratedCharacter the character to be decorated
     */
    public CharacterDecorator(Character decoratedCharacter) {
        // Initializing the super class with decorated character's properties.
        super(decoratedCharacter.getName(), decoratedCharacter.getRace(),
                decoratedCharacter.getHealth(), decoratedCharacter.getAttackPower(),
                decoratedCharacter.getSpeed(), decoratedCharacter.getDefense());
        this.decoratedCharacter = decoratedCharacter;
    }

    @Override
    public void displayStats() {
        super.displayStats();  // Call the decorated character's displayStats method
    }

    @Override
    public void attackEnemy(Enemy target) {
        decoratedCharacter.attackEnemy(target);
    }

    @Override
    public void reduceHealth(int damage) {
        decoratedCharacter.reduceHealth(damage);  // Delegates handling to the decorated object
    }

    /**
     * This method should be implemented to remove the decorator and restore the original character state.
     */
    public abstract void unequip();

    // Delegate all other methods to maintain the original object's behavior
    @Override
    public String getName() {
        return decoratedCharacter.getName();
    }

    @Override
    public int getHealth() {
        return decoratedCharacter.getHealth();
    }

    @Override
    public int getAttackPower() {
        return decoratedCharacter.getAttackPower();
    }

    @Override
    public int getSpeed() {
        return decoratedCharacter.getSpeed();
    }

    @Override
    public int getDefense() {
        return decoratedCharacter.getDefense();
    }

    @Override
    public void setHealth(int health) {
        decoratedCharacter.setHealth(health);
    }

    @Override
    public void setAttackPower(int attackPower) {
        decoratedCharacter.setAttackPower(attackPower);
    }

    @Override
    public void setSpeed(int speed) {
        decoratedCharacter.setSpeed(speed);
    }

    @Override
    public void setDefense(int defense) {
        decoratedCharacter.setDefense(defense);
    }
}




