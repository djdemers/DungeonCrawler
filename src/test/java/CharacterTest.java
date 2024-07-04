import static org.junit.jupiter.api.Assertions.*;

import characters.Race;
import characters.consumables.HealthPotion;
import characters.decorators.Sword;
import enemies.Goblin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Character;
import characters.Warrior;
import enemies.Enemy;
import interfaces.Item;

/**
 * Test class for Character.
 */
public class CharacterTest {
    private Character hero;
    private Enemy enemy;

    @BeforeEach
    public void setUp() {
        hero = new Warrior("hero", Race.HUMAN);
        enemy = new Goblin();
    }

    @Test
    public void testCharacterInitialization() {
        assertEquals(82, hero.getHealth(), "Health should match initial setup.");
        assertEquals(12, hero.getMana(), "Mana should match initial setup.");
        assertEquals(12, hero.getAttackPower(), "Attack power should be set correctly with racial bonuses.");
        assertEquals(7, hero.getSpeed(), "Speed should be set correctly.");
        assertEquals(7, hero.getDefense(), "Defense should be correct with racial bonuses.");
    }

    @Test
    public void testAttackEnemy() {
        hero.attackEnemy(enemy);
        assertTrue(enemy.getHealth() < 50, "Enemy health should decrease after being attacked.");
    }

    @Test
    public void testReceiveDamage() {
        int initialHealth = hero.getHealth();
        hero.reduceHeroHealth(enemy.getAttackPower());
        assertTrue(hero.getHealth() < initialHealth, "Hero health should decrease after taking damage.");
    }
    @Test
    public void testIsAlive() {
        assertTrue(hero.isAlive(), "Hero should initially be alive.");
        hero.setHealth(0);
        assertFalse(hero.isAlive(), "Hero should be dead when health is 0.");
    }

    @Test
    public void testUseItemFromInventory() {
        Item healPotion = new HealthPotion("Small Heal", "Heals 20 health", 20, 50);
        hero.getInventory().addItem(healPotion);
        hero.getInventory().useItem("Small Heal");
        assertEquals(82, hero.getHealth(), "Hero's health should increase after using a healing potion.");
    }

    @Test
    public void testEquipItemFromInventory() {

        Item sword = new Sword("Iron Sword", hero,  5, 150);
        hero.getInventory().addItem(sword);
        hero.getInventory().equipItem("Iron Sword");
        assertEquals(17, hero.getAttackPower(), "Hero's attack power should increase after equipping a sword.");
    }
    @Test
    public void testHealthNeverNegative() {
        hero.setHealth(1); // Set hero's health to a low value
        hero.reduceHeroHealth(10); // Apply damage that would potentially reduce health below zero
        assertTrue(hero.getHealth() >= 0, "Health should never go negative.");
    }

}
