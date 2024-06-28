import characters.Character;
import characters.consumables.HealthPotion;
import characters.decorators.CharacterDecorator;
import characters.decorators.Sword;
import enemies.Enemy;
import factories.CharacterFactory;
import factories.EnemyFactory;
import factories.ItemFactory;
import inventory.Inventory;
import inventory.Shop;
import service.Equipable;
import service.Item;
import service.SingleUse;

public class Main {

    public static void main(String[] args) {
        Main app = new Main();
        System.out.println(app.getGreeting());
        // Create a character using a factory method
        Character hero = CharacterFactory.createRandomCharacter("Hero");
        System.out.println(hero.getClass().getSimpleName() + " is the class you have been assigned");
        System.out.println(hero.getRace().getName() + " is the race that you have been assigned");

        //Initial Stats
        System.out.println("Before any decoration:");
        hero.displayStats();

        // Set up the inventory
        Inventory heroInventory = hero.getInventory();


        // Create a shop and display its items
        Shop shop = new Shop(hero);
        shop.displayItems();  // Display items available for sale

        // Example of buying an item from the shop
        if (!shop.getItemsForSale().isEmpty()) {
            Item itemToBuy = shop.getItemsForSale().get(0);
            shop.buyItem(hero, itemToBuy);
            System.out.println("After buying an item:");
            heroInventory.listItems();
        }

        // Using and equipping items as before
        // You might want to check if the item exists before using it
        if (heroInventory.getItem("Health Potion") != null) {
            heroInventory.useItem("Health Potion");
        }
        if (heroInventory.getItem("Iron Sword") != null) {
            heroInventory.equipItem("Iron Sword");
        }

        // Display stats after equipping
        System.out.println("After using items and equipping:");
        hero.displayStats();

        // Example combat scenario
        GameMediator mediator = new GameMediatorImpl(hero);
        Enemy initialEnemy = EnemyFactory.createRandomSmallEnemy();
        mediator.fight(hero, initialEnemy);
    }
    public String getGreeting() {
        return "Welcome to the Dungie!";
    }
}
