package service;
import characters.Character;

public interface SingleUse extends Item {
    void use(Character character);
}
