import static org.junit.jupiter.api.Assertions.*;

import characters.Race;
import characters.consumables.HealthPotion;
import characters.decorators.Sword;
import enemies.Dragon;
import enemies.Goblin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.Character;
import characters.Warrior;
import enemies.Enemy;
import service.Item;

/**
 * Test class for Character.
 */
public class CharacterTest {
    private Character hero;
    private Enemy enemy;

    @BeforeEach
    public void setUp() {
        // Initialize a character with controlled stats for predictability in tests.
        hero = new Warrior("hero", Race.HUMAN);
        enemy = new Goblin();
    }

    @Test
    public void testCharacterInitialization() {
        assertEquals(82, hero.getHealth(), "Health should match initial setup.");
        assertEquals(7, hero.getMana(), "Mana should match initial setup.");
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
        hero.heroIsHit(enemy);
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
        // Assuming Item interface and HealPotion implements SingleUse
        Item healPotion = new HealthPotion("Small Heal", "Heals 20 health", 20);
        hero.getInventory().addItem(healPotion);
        hero.getInventory().useItem("Small Heal");
        assertEquals(82, hero.getHealth(), "Hero's health should increase after using a healing potion.");
    }

    @Test
    public void testEquipItemFromInventory() {

        Item sword = new Sword("Iron Sword", hero,  5);
        hero.getInventory().addItem(sword);
        hero.getInventory().equipItem("Iron Sword");
        assertEquals(17, hero.getAttackPower(), "Hero's attack power should increase after equipping a sword.");
    }
}
