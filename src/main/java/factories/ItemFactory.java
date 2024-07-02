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
import service.Item;
import service.SingleUse;

import java.util.Random;

public class ItemFactory {

    private static Random random = new Random();

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
    public static Item createRandomItem(Character character) {
        int choice = random.nextInt(100);

        if (choice < 20) {
            return createHealthPotion(random.nextInt(70) + 30);
        } else if (choice < 40) {
            return createManaPotion(random.nextInt(80) + 20);
        } else if (choice < 55) {
            return createMagicScroll("Fireball Scroll", "Casts a mighty fireball", random.nextInt(25) + 25); // Power 25-50
        } else if (choice < 60) {
            return createSword("Iron Sword", character, random.nextInt(10) + 10);
        } else if (choice < 70) {
            return createArmor("Leather Armor", character, random.nextInt(10) + 10);
        } else if (choice < 80) {
            return createBoots("Leather Boots", character, random.nextInt(10) +10);
        } else if (choice < 90) {
            return createSword("Mega Fireball Scroll", character, random.nextInt(50) + 50);
        } else {
            return createArmor("Dragon Scale Armor", character, random.nextInt(30) + 25);
        }
    }

}
