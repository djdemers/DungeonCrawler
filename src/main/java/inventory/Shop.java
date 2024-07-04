package inventory;

import characters.Character;
import factories.ItemFactory;
import interfaces.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a shop within the game where characters can buy items.
 * This class manages the inventory of items for sale and handles transactions.
 */
public class Shop {
    private List<Item> itemsForSale;
    private Random random;
    private Character owner;

    /**
     * Constructs a new Shop for a specific character.
     * @param owner The character who is interacting with this shop.
     */
    public Shop(Character owner) {
        this.itemsForSale = new ArrayList<>();
        this.owner = owner;
        this.random = new Random();
        generateInventory();
    }

    /**
     * Generates the inventory of items for sale, including a random chance for a special item.
     */
    private void generateInventory() {
        itemsForSale.clear();
        itemsForSale.add(ItemFactory.createRandomItem(owner));
        itemsForSale.add(ItemFactory.createRandomItem(owner));

        // Generate a special item with a 5% chance to be an instant level-up item
        if (random.nextDouble() < 0.05) {
            itemsForSale.add(ItemFactory.createInstantLevelUp());
        } else {
            itemsForSale.add(ItemFactory.createRandomItem(owner));
        }
    }

    /**
     * Displays the items currently available for sale in the shop.
     */
    public void displayItems() {
        System.out.println("Items for sale:");
        itemsForSale.forEach(item -> System.out.println(item.getName() + " - Price: " + item.getPrice() + " gold"));
    }

    /**
     * Allows a character to buy an item if they have enough gold.
     * @param character The character attempting to buy an item.
     * @param item The item to be purchased.
     */
    public void buyItem(Character character, Item item) {
        Inventory inventory = character.getInventory();
        int gold = inventory.getGold();

        if (gold >= item.getPrice()) {
            inventory.addItem(item);
            inventory.spendGold(item.getPrice());
            itemsForSale.remove(item);
            System.out.println(character.getName() + " bought " + item.getName() + " for " + item.getPrice() + " gold.");
        } else {
            System.out.println(character.getName() + " does not have enough gold to buy " + item.getName() + ".");
        }
    }

    /**
     * Attempts to buy a random item from the shop that the character can afford.
     * @param character The character trying to buy an item.
     */
    public void attemptToBuyRandomItem(Character character) {
        List<Item> itemsToTry = new ArrayList<>(itemsForSale);

        for (Item item : itemsToTry) {
            if (character.getInventory().getGold() >= item.getPrice()) {
                buyItem(character, item);
                return;
            }
        }
        System.out.println("Shop closes as " + character.getName() + " cannot afford any items.");
    }

    /**
     * Returns the list of items currently for sale in the shop.
     * @return A list of items for sale.
     */
    public List<Item> getItemsForSale() {
        return itemsForSale;
    }
}
