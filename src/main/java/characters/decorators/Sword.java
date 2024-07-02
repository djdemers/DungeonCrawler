package characters.decorators;

import characters.Character;
import service.Equipable;

public class Sword extends CharacterDecorator implements Equipable {
    private String itemName;
    private int attackBoost;

    public Sword(String name, Character decoratedCharacter, int attackBoost) {
        super(decoratedCharacter);
        this.itemName = name;
        this.attackBoost = attackBoost;
    }
    @Override
    public CharacterDecorator equip(Character character) {
        this.apply();
        System.out.println(character.getName() + " equips " + itemName + " and gains " + attackBoost + " attack.");
        return this;
    }
    @Override
    public void unequip(Character character) {
        this.revert();  // Reverts this decorator's effects
        System.out.println(character.getName() + " unequips " + itemName);
    }
    @Override
    public void apply() {
        decoratedCharacter.setAttackPower(decoratedCharacter.getAttackPower() + attackBoost);
    }
    @Override
    public void revert() {
        decoratedCharacter.setAttackPower(decoratedCharacter.getAttackPower() - attackBoost);
    }
    public String getName(){
        return itemName;
    }

    @Override
    public String getType(){
        return "Sword";
    }
    @Override
    public int getBonus(){
        return attackBoost;
    }

}




