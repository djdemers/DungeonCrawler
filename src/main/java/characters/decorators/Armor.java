package characters.decorators;

import characters.Character;
import service.Equipable;

public class Armor extends CharacterDecorator implements Equipable {
    private String itemName;
    private int additionalDefense;

    public Armor(String name, Character decoratedCharacter, int additionalDefense) {
        super(decoratedCharacter);
        this.itemName = name;
        this.additionalDefense = additionalDefense;
    }
    @Override
    public CharacterDecorator equip(Character character) {
       this.apply();
        System.out.println(character.getName() + " equips " + itemName + " and gains " + additionalDefense + " defense.");
       return this;
    }
    @Override
    public void unequip(Character character) {
        this.revert();
        System.out.println(character.getName() + " unequips " + itemName);
    }
    @Override
    public void apply() {
        decoratedCharacter.setDefense(decoratedCharacter.getDefense() + additionalDefense);
    }
    @Override
    public void revert() {
        decoratedCharacter.setDefense(decoratedCharacter.getDefense() - additionalDefense);
    }

    public String getName(){
        return itemName;
    }

    @Override
    public String getType(){
        return "Armor";
    }
    @Override
    public int getBonus(){
        return additionalDefense;
    }

}