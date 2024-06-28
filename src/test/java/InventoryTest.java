import static org.junit.jupiter.api.Assertions.*;

import characters.consumables.HealthPotion;
import characters.decorators.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import characters.Character;
import characters.Warrior;
import characters.Race;
import service.Item;
import inventory.Inventory;

public class InventoryTest {
    private Inventory inventory;
    private Character owner;
    private Item potion;
    private Item sword;

    @BeforeEach
    public void setUp() {
        // Setup a test character and inventory
        owner = new Warrior("Test Warrior", Race.HUMAN);
        inventory = new Inventory(owner);

        // Create test items
        potion = new HealthPotion("Health Potion", "Restores 50 health", 50);
        sword = new Sword("Sword", owner, 10);
    }

    @Test
    public void testAddAndRemoveItem() {
        assertEquals(0, inventory.getItemCount(), "Inventory should initially be empty.");

        inventory.addItem(potion);
        assertEquals(1, inventory.getItemCount(), "Inventory should contain one item after addition.");

        inventory.removeItem(potion);
        assertEquals(0, inventory.getItemCount(), "Inventory should be empty after removal.");
    }

    @Test
    public void testUseItem() {
        inventory.addItem(potion);
        inventory.useItem("Health Potion");
        assertNull(inventory.getItem("Health Potion"), "Health potion should be used and removed from inventory.");
    }

    @Test
    public void testEquipItem() {
        inventory.addItem(sword);
        inventory.equipItem("Sword");
        assertTrue(owner.getAttackPower() > 10, "Owner's attack power should increase after equipping a sword.");
    }

    @Test
    public void testGoldManagement() {
        assertEquals(0, inventory.getGold(), "Initial gold should be 0.");

        inventory.addGold(100);
        assertEquals(100, inventory.getGold(), "Gold should be 100 after addition.");

        inventory.spendGold(50);
        assertEquals(50, inventory.getGold(), "Gold should be 50 after spending.");

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            inventory.spendGold(100);
        });
        assertEquals("Not enough gold.", exception.getMessage(), "Attempting to spend more gold than available should throw exception.");
    }

    @Test
    public void testInventoryEmpty() {
        assertTrue(inventory.isInventoryEmpty(), "Inventory should initially be empty.");

        inventory.addItem(potion);
        assertFalse(inventory.isInventoryEmpty(), "Inventory should not be empty after adding an item.");

        inventory.removeItem(potion);
        assertTrue(inventory.isInventoryEmpty(), "Inventory should be empty again after removing the item.");
    }
}


