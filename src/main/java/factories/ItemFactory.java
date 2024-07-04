package factories;

import characters.Character;
import characters.consumables.HealthPotion;
import characters.consumables.InstantLevelUp;
import characters.consumables.MagicScroll;
import characters.consumables.ManaPotion;
import characters.decorators.Armor;
import characters.decorators.Boots;
import characters.decorators.Sword;
import interfaces.Equipable;
import interfaces.Item;
import interfaces.SingleUse;

import java.util.Random;

/**
 * Factory class for creating various types of items including consumables and equipable items.
 * This class centralizes the creation of items to manage complexity and maintain consistency across item types.
 */
public class ItemFactory {

    private static Random random = new Random();

    /**
     * Creates a health potion.
     *
     * @param healingAmount The amount of health the potion restores.
     * @return A new health potion.
     */
    public static SingleUse createHealthPotion(int healingAmount) {
        return new HealthPotion("Health Potion", "Restores " + healingAmount + " health", healingAmount, 50);
    }

    /**
     * Creates a mana potion.
     *
     * @param manaAmount The amount of mana the potion restores.
     * @return A new mana potion.
     */
    public static SingleUse createManaPotion(int manaAmount) {
        return new ManaPotion("Mana Potion", "Restores " + manaAmount + " mana", manaAmount, 50);
    }

    /**
     * Creates a magic scroll.
     *
     * @param name The name of the scroll.
     * @param description A brief description of the scroll's effect.
     * @param power The power of the magic effect.
     * @return A new magic scroll.
     */
    public static SingleUse createMagicScroll(String name, String description, int power) {
        return new MagicScroll(name, description, power, 100);
    }

    /**
     * Creates an instant level-up item.
     *
     * @return A new instant level-up item.
     */
    public static SingleUse createInstantLevelUp() {
        return new InstantLevelUp("Mystic Tome", "Instantly level up!", 1, 300);
    }

    /**
     * Creates a sword with specified attack boost.
     *
     * @param name The name of the sword.
     * @param character The character who may potentially equip the sword.
     * @param attackBoost The attack power boost provided by the sword.
     * @return A new sword.
     */
    public static Equipable createSword(String name, Character character, int attackBoost) {
        return new Sword(name, character, attackBoost, 150);
    }

    /**
     * Creates armor with specified defense boost.
     *
     * @param name The name of the armor.
     * @param character The character who may potentially equip the armor.
     * @param defenseBoost The defense boost provided by the armor.
     * @return A new armor.
     */
    public static Equipable createArmor(String name, Character character, int defenseBoost) {
        return new Armor(name, character, defenseBoost, 150);
    }

    /**
     * Creates boots with specified speed boost.
     *
     * @param name The name of the boots.
     * @param character The character who may potentially equip the boots.
     * @param speedBoost The speed boost provided by the boots.
     * @return A new pair of boots.
     */
    public static Equipable createBoots(String name, Character character, int speedBoost) {
        return new Boots(name, character, speedBoost, 150);
    }

    /**
     * Generates a random item based on a predefined probability distribution.
     *
     * @param character The character for whom the item may be suitable.
     * @return A randomly selected item, potentially based on character attributes or needs.
     */
    public static Item createRandomItem(Character character) {
        int choice = random.nextInt(100);

        if (choice < 20) {
            return createHealthPotion(random.nextInt(70) + 30);
        } else if (choice < 40) {
            return createManaPotion(random.nextInt(80) + 20);
        } else if (choice < 55) {
            return createMagicScroll("Fireball Scroll", "Casts a mighty fireball", random.nextInt(25) + 25);
        } else if (choice < 60) {
            return createSword("Iron Sword", character, random.nextInt(10) + 10);
        } else if (choice < 70) {
            return createArmor("Leather Armor", character, random.nextInt(10) + 10);
        } else if (choice < 80) {
            return createBoots("Leather Boots", character, random.nextInt(10) + 10);
        } else if (choice < 90) {
            return createMagicScroll("Mega Fireball Scroll", "Cast a HUGE fireball", random.nextInt(50) + 50);
        } else {
            return createArmor("Dragon Scale Armor", character, random.nextInt(30) + 25);
        }
    }
}
