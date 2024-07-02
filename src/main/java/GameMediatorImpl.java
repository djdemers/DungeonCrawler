import characters.Character;
import enemies.Enemy;
import factories.EnemyFactory;

import factories.ItemFactory;
import inventory.Inventory;
import service.Item;

import java.util.Random;


/**
 * Implementation of the GameMediator interface to manage combat and level progression in the game.
 */
public class GameMediatorImpl implements GameMediator {
    private Character hero;
    private int currentLevel = 1;
    Inventory inventory;

    /**
     * Constructs a GameMediator with the initial hero character.
     *
     * @param hero the hero character that the player controls
     */
    public GameMediatorImpl(Character hero) {
        this.hero = hero;
    }

    /**
     * Engages in a fight between the hero and an enemy until one is defeated.
     * Progresses to the next level if the hero survives.
     *
     * @param hero the hero character
     * @param enemy the enemy character
     */
    @Override
    public void fight(Character hero, Enemy enemy) {
        System.out.println("Prepare yourself a " + enemy.getName() + " appears!");
        while (hero.isAlive() && enemy.isAlive()) {
            // Hero's turn
            heroTurn(hero, enemy);
            // Enemy's turn, if still alive
            if (enemy.isAlive()) {
                enemyTurn(enemy, hero);
            }
            // Update effects at the end of each round
            updateEffects(hero, enemy);
        }
        checkEndOfBattle(hero, enemy);
    }
    private void heroTurn(Character hero, Enemy enemy) {
        // Implementation of what happens during the hero's turn
        hero.attackEnemy(enemy);
        // Any additional actions can be placed here
    }

    private void enemyTurn(Enemy enemy, Character hero) {
        // Implementation of what happens during the enemy's turn
        enemy.attackHero(hero);

    }

    private void updateEffects(Character hero, Enemy enemy) {
        // Update or reduce the duration of effects on both hero and enemy
        hero.updateTemporaryEffects();
        //enemy.updateTemporaryEffects();
    }

    private void checkEndOfBattle(Character hero, Enemy enemy) {
        hero.displayStats();
        hero.getInventory().listItems();
        if (!hero.isAlive()) {
            gameOver();
        } else if (!enemy.isAlive()) {
            System.out.println(hero.getName() + " has defeated " + enemy.getName() + "!");
            //triggerRandomEvent(hero);
            triggerChestEvent(hero);
            hero.getInventory().useHealthPotionIfNecessary();
            hero.getInventory().useManaPotionIfNecessary();
            hero.displayStats();
            nextLevel();
        }
    }

    /**
     * Advances the game to the next level and generates a new enemy.
     * The type of enemy depends on the current level number.
     */
    public void nextLevel() {
        currentLevel++;
        Enemy enemy = generateEnemyForCurrentLevel();
        System.out.println("Welcome to level " + currentLevel);
        fight(hero, enemy);
    }

    /**
     * Ends the game and prints the final level reached by the hero.
     */
    @Override
    public void gameOver() {
        System.out.println("Game Over. " + hero.getName() + " reached level " + currentLevel + ".");
    }

    /**
     * Determines the type of enemy to generate based on the current level.
     *
     * @return the enemy to face in the next level
     */
    private Enemy generateEnemyForCurrentLevel() {
        if (currentLevel % 10 == 0) {
            return EnemyFactory.createRandomBoss();
        } else if (currentLevel % 5 == 0) {
            return EnemyFactory.createRandomMediumEnemy();
        } else {
            return EnemyFactory.createRandomSmallEnemy();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    // GAME LOGIC FOR CHESTS AND SHOPS
    private void triggerRandomEvent(Character hero) {
        Random random = new Random();
        double chance = random.nextDouble();

        if (chance < 0.15) {  // 15% chance for a chest to appear
            triggerChestEvent(hero);
        } else if (chance < 0.25) {  // Additional 10% chance for a shop to appear
            triggerShopEvent();
        } else {
            System.out.println("The battle is over.");
        }
    }


    public static void triggerChestEvent(Character hero) {
        System.out.println("A chest appears!");
        Inventory inventory = hero.getInventory();
        Random random = new Random();

        Item item = ItemFactory.createRandomItem(hero);
        System.out.println("Added " + item.getName() + " to inventory from a found chest.");
        inventory.addItem(item);

        if (random.nextBoolean()) {
            int goldAmount = random.nextInt(101) + 50; // 50 to 150 gold
            inventory.addGold(goldAmount);
            System.out.println("Added " + goldAmount + " gold to inventory from a found chest.");
        }
    }

    private void triggerShopEvent() {
        System.out.println("You stumble upon a travelling merchant!");
        openShop(hero);
    }

    private void openShop(Character hero) {
        // This method would interact with the hero's inventory and gold
        // Example: shop.sellItems(hero);
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    // Equiping and Using Items


}
