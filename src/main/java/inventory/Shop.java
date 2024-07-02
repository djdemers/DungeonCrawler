package inventory;

import characters.Character;
import factories.ItemFactory;
import service.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop {
    private List<Item> itemsForSale;
    private Random random;
    private Character owner;

    public Shop(Character owner) {
        this.itemsForSale = new ArrayList<>();
        this.owner = owner;
        this.random = new Random();
        generateInventory();
    }

    private void generateInventory() {
        // Clear previous items
        itemsForSale.clear();

        // Generate two guaranteed random items
        itemsForSale.add(ItemFactory.createRandomItem(owner));
        itemsForSale.add(ItemFactory.createRandomItem(owner));

        // Generate a third item, with a small chance to be an instant level-up
        if (random.nextDouble() < 0.05) {  // 5% chance for an instant level-up
            itemsForSale.add(ItemFactory.createInstantLevelUp());
        } else {
            itemsForSale.add(ItemFactory.createRandomItem(owner));
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
