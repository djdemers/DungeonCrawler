import characters.Race;
import inventory.Inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class InventoryTest {
    private Inventory inventory;
    private HealthPotionStub healthPotion;
    private CharacterStub character;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        character = new CharacterStub("Hero", Race.HUMAN, 100, 100, 10, 5);
        healthPotion = new HealthPotionStub();
    }

    @Test
    void testAddItem() {
        inventory.addItem( healthPotion);
        assertEquals(1, inventory.getItemCount());
    }

    @Test
    void testUseItem() {
        inventory.addItem(healthPotion);
        inventory.useItem("Health Potion", character);
        assertTrue(healthPotion.isUsed());
        assertTrue(inventory.isInventoryEmpty());
    }

    @Test
    void testAddGold() {
        inventory.addGold(100);
        assertEquals(100, inventory.getGold());
    }

    @Test
    void testSpendGoldSuccess() {
        inventory.addGold(100);
        inventory.spendGold(50);
        assertEquals(50, inventory.getGold());
    }

    @Test
    void testSpendGoldFailure() {
        inventory.addGold(50);
        assertThrows(IllegalStateException.class, () -> inventory.spendGold(100));
    }
}

