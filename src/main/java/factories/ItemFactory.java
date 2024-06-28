package factories;

import characters.Character;
import characters.consumables.HealthPotion;
import characters.consumables.InstantLevelUp;
import characters.consumables.MagicScroll;
import characters.consumables.ManaPotion;
import characters.decorators.Armor;
import characters.decorators.Boots;
import characters.decorators.Sword;
import service.Equipable;
import service.SingleUse;

public class ItemFactory {

    /**
     * Creates a health potion.
     *
     * @param healingAmount The amount of health the potion restores.
     * @return A new health potion.
     */
    public static SingleUse createHealthPotion(int healingAmount) {
        return new HealthPotion("Health Potion", "Restores " + healingAmount + " health", healingAmount);
    }
    public static SingleUse createManaPotion(int manaAmount) {
        return new ManaPotion("Mana Potion", "Restores " + manaAmount + " health", manaAmount);
    }
    public static SingleUse createMagicScroll(String name, String description, int power) {
        return new MagicScroll(name, description, power);
    }
    public static SingleUse createInstantLevelUp() {
        return new InstantLevelUp("Mystic Tome", "Instantly level up!", 1);
    }




    public static Equipable createSword(String name, Character character, int attackBoost) {
        return new Sword(name, character, attackBoost);
    }


    public static Equipable createArmor(String name, Character character, int defenseBoost) {
        return new Armor(name, character, defenseBoost);
    }
    public static Equipable createBoots(String name, Character character, int speedBoost){
        return new Boots(name, character, speedBoost);
    }
}
