package inventory;

import characters.Character;
import factories.ItemFactory;
import service.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop {
    private List<Item> itemsForSale;
    private Random random = new Random();
    private Character genericHero; // For the possibility that hero is null.

    public Shop(Character genericHero) {
        this.itemsForSale = new ArrayList<>();
        this.genericHero = genericHero;
        generateInventory();
    }

    private void generateInventory() {
        itemsForSale.clear();
        for (int i = 0; i < 3; i++) {
            itemsForSale.add(generateRandomItem());
        }
    }

    private Item generateRandomItem() {
        int choice = random.nextInt(100);
        if (choice < 50) {
            return ItemFactory.createHealthPotion(50 + random.nextInt(51));
        } else if (choice < 75) {
            // Ensure there is a generic hero or handle it differently if not available
            if (genericHero != null) {
                return ItemFactory.createSword("Sword", genericHero, 10 + random.nextInt(11));
            } else {
                // Handle case where no character is available, maybe return a different item or null
                return ItemFactory.createHealthPotion(50); // Fallback to potion or another item
            }
        } else if (choice < 95) {
            return ItemFactory.createMagicScroll("Magic Scroll", "A powerful spell", 1);
        } else {
            return ItemFactory.createInstantLevelUp();
        }
    }

    public void displayItems() {
        System.out.println("Items for sale:");
        itemsForSale.forEach(item -> System.out.println(item.getName()));
    }

    public void buyItem(Character character, Item item) {
        Inventory inventory = character.getInventory();
        if (itemsForSale.contains(item)) {
            inventory.addItem(item);
            itemsForSale.remove(item);
            System.out.println(character.getName() + " bought " + item.getName());
        } else {
            System.out.println("Item is not available.");
        }
    }

    public List<Item> getItemsForSale() {
        return itemsForSale;
    }
}
