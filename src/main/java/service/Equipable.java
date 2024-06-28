package service;
import characters.decorators.CharacterDecorator;
import characters.Character;
public interface Equipable extends Item {
    CharacterDecorator equip(Character character);
    void unequip(Character character);
}