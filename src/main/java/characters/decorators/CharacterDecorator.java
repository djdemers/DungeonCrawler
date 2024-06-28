package characters.decorators;
import characters.Character;

/**
 * Abstract decorator for character objects to extend or modify their behavior dynamically.
 * This class provides a framework for adding additional capabilities or modifying existing ones.
 */
public abstract class CharacterDecorator extends Character {
    protected Character decoratedCharacter;

    protected String name;

    /**
     * Initializes a new CharacterDecorator that wraps a given Character object.
     *
     * @param decoratedCharacter the character to be decorated
     */
    public CharacterDecorator(Character decoratedCharacter) {
        // Initializing the super class with decorated character's properties.
        super(decoratedCharacter.getName(), decoratedCharacter.getRace(),
                decoratedCharacter.getHealth(), decoratedCharacter.getAttackPower(),
                decoratedCharacter.getSpeed(), decoratedCharacter.getDefense(),
                decoratedCharacter.getMana());
        this.decoratedCharacter = decoratedCharacter;
    }

    // Method to apply the effects of the decorator
    public abstract void apply();

    // Method to revert the effects of the decorator
    public abstract void revert();

    @Override
    public void displayStats() {
        super.displayStats();  // Call the decorated character's displayStats method
    }

    @Override
    public int getAttackPower() {
        return super.getAttackPower();
    }
}




