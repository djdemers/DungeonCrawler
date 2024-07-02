package characters.decorators;

import characters.Character;
import service.Equipable;

public class Boots extends CharacterDecorator implements Equipable {
    private String itemName;
    private int additionalSpeed;

    public Boots(String name, Character decoratedCharacter, int additionalSpeed) {
        super(decoratedCharacter);
        this.itemName = name;
        this.additionalSpeed = additionalSpeed;

    }
    @Override
    public CharacterDecorator equip(Character character) {
        this.apply();  // Applies this decorator's effects
        System.out.println(character.getName() + " equips " + itemName + " and gains " + additionalSpeed + " speed.");
        return this;
    }
    @Override
    public void unequip(Character character) {
        this.revert();  // Reverts this decorator's effects
        System.out.println(character.getName() + " unequips " + itemName);
    }
    @Override
    public void apply(){
        decoratedCharacter.setSpeed(decoratedCharacter.getSpeed() + additionalSpeed);
    }
    @Override
    public void revert(){
        decoratedCharacter.setSpeed(decoratedCharacter.getSpeed() - additionalSpeed);
    }
    public String getName(){
        return itemName;
    }
    @Override
    public String getType(){
        return "Boots";
    }
    @Override
    public int getBonus(){
        return additionalSpeed;
    }

}

