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
      super(decoratedCharacter.getName(),decoratedCharacter.getRace(),
              decoratedCharacter.getHealth(),decoratedCharacter.getAttackPower(),
              decoratedCharacter.getSpeed(), decoratedCharacter.getDefense(),
              decoratedCharacter.getMana());
        this.decoratedCharacter = decoratedCharacter;
    }

    /**
     * Applies the specific effects of the decorator to the character.
     * This could include changes like temporary stat boosts or new abilities.
     */
    public abstract void apply();

    /**
     * Reverts the effects previously applied by the decorator, restoring the character's original state.
     */
    public abstract void revert();

    /**
     * Displays the character's stats, enhanced or modified by the decorator.
     */
    @Override
    public void displayStats() {
        decoratedCharacter.displayStats();
    }
}