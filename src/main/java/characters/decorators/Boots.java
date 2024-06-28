/*
package characters.decorators;

import characters.Character;
import service.SingleUse;

*/
/**
 * Decorator that enhances a character's attack power and speed by equipping a dagger.
 *//*

public class Dagger extends CharacterDecorator implements SingleUse {
    private int additionalSpeed;

    private String name;
    private String description;

    public Dagger(Character decoratedCharacter, int additionalSpeed, String name, String description) {
        super(decoratedCharacter);
        this.additionalSpeed = additionalSpeed;
        this.name = name;
        this.description = description;
    }
    @Override
    public void apply(Character character){
        character.setSpeed(character.getSpeed() + additionalSpeed);
    }
    @Override
    public void revert(Character character){
        character.setSpeed(character.getSpeed() - additionalSpeed);
    }

    */
/**
     * Gets the name of the dagger.
     * @return A string representing the name of the dagger.
     *//*

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getDescription(){
        return description;
    }

}
*/
