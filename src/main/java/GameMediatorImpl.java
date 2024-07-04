import characters.Character;
import characters.skills.SkillManager;
import enemies.Enemy;
import factories.EnemyFactory;
import factories.ItemFactory;
import interfaces.EnemyScalingStrategy;
import interfaces.Item;
import inventory.Inventory;
import inventory.Shop;
import java.util.Random;

/**
 * Manages game mechanics, including combat, level progression, and random events like chests and shops.
 * This class acts as a central mediator for various game actions, orchestrating the flow of the game,
 * handling interactions between different game components, and maintaining game state.
 */
public class GameMediatorImpl implements GameMediator {
    private static final int MAX_LEVEL = 20; // The maximum level in the game
    private Character hero;                 // The main character controlled by the player
    private int currentLevel = 0;           // Tracks the current level of the game
    private Inventory inventory;            // The inventory of the hero
    private SkillManager skillManager;      // Manages skills for all characters
    private EnemyFactory enemyFactory;      // Factory for creating enemies with scaling

    /**
     * Constructs a game mediator with necessary components.
     * @param hero The player's character.
     * @param scalingStrategy The strategy used to scale enemy attributes as levels progress.
     */
    public GameMediatorImpl(Character hero, EnemyScalingStrategy scalingStrategy) {
        this.hero = hero;
        this.inventory = hero.getInventory();
        this.skillManager = new SkillManager();
        this.enemyFactory = new EnemyFactory(scalingStrategy);
    }

    /**
     * Initiates a battle between the hero and an enemy. Continues until one of them is defeated.
     * If the hero wins, the game progresses to the next level.
     * @param hero The hero character.
     * @param enemy The enemy character.
     */
    public void fight(Character hero, Enemy enemy) {
        System.out.println("Prepare yourself a " + enemy.getName() + " appears!");
        enemy.displayStats();
        while (hero.isAlive() && enemy.isAlive()) {
            heroTurn(hero, enemy);
            if (enemy.isAlive()) {
                enemyTurn(enemy, hero);
            }
            updateEffects(hero, enemy);
            checkEndOfBattle(hero, enemy);
        }
    }

    /**
     * Manages the hero's turn during the battle.
     * @param hero The hero character.
     * @param enemy The current enemy character.
     */
    private void heroTurn(Character hero, Enemy enemy) {
        hero.attackEnemy(enemy);
    }

    /**
     * Manages the enemy's turn during the battle.
     * @param enemy The enemy character.
     * @param hero The hero character.
     */
    private void enemyTurn(Enemy enemy, Character hero) {
        enemy.attackHero(hero);
    }

    /**
     * Updates temporary effects on both the hero and the enemy.
     * @param hero The hero character.
     * @param enemy The enemy character.
     */
    private void updateEffects(Character hero, Enemy enemy) {
        hero.updateTemporaryEffects();
        //enemy.updateTemporaryEffects();
    }

    /**
     * Checks the outcome of the battle and handles post-battle events.
     * @param hero The hero character.
     * @param enemy The enemy character.
     */
    private void checkEndOfBattle(Character hero, Enemy enemy) {
        if (!hero.isAlive()) {
            gameOver();
        } else if (!enemy.isAlive()) {
            System.out.println(hero.getName() + " has defeated " + enemy.getName() + "!");
            handlePostBattle();
        }
    }

    /**
     * Handles events after a battle, such as triggering random events and managing health checks.
     */
    private void handlePostBattle() {
        triggerRandomEvent(hero);
        if (hero.getHealth() < hero.getMaxHealth() * 0.15) {
            goToTopFloor();
        } else {
            nextLevel();
        }
    }

    /**
     * Resets the game to the first level, restoring the hero's health and mana to full.
     */
    private void goToTopFloor() {
        hero.setHealth(hero.getMaxHealth());
        hero.setMana(hero.getMaxMana());
        currentLevel = 1;
        System.out.println("Health is below 15%. Returning to the top floor with full health and mana.");
    }

    /**
     * Advances the game to the next level and generates a new enemy.
     */
    public void nextLevel() {
        if (currentLevel < MAX_LEVEL) {
            currentLevel++;
            Enemy enemy = generateEnemyForCurrentLevel();
            System.out.println("Welcome to level " + currentLevel);
            fight(hero, enemy);
        } else {
            endGame();
        }
    }

    /**
     * Ends the game with a victory message.
     */
    public void endGame() {
        System.out.println("You have reached the end of the dungeon! " + hero.getName() + " is victorious!");
        System.exit(0);
    }

    /**
     * Ends the game, displaying a game over message with the final level reached by the hero.
     */
    public void gameOver() {
        System.out.println("Game Over. " + hero.getName() + " reached level " + currentLevel + ".");
        System.exit(0);
    }

    /**
     * Generates an enemy for the current level, choosing between small, medium, and boss types based on the level number.
     * @return The enemy to face in the current level.
     */
    private Enemy generateEnemyForCurrentLevel() {
        if (currentLevel % 10 == 0) {
            return enemyFactory.createRandomBoss(currentLevel);
        } else if (currentLevel % 5 == 0) {
            return enemyFactory.createRandomMediumEnemy(currentLevel);
        } else {
            return enemyFactory.createRandomSmallEnemy(currentLevel);
        }
    }

    /**
     * Triggers a random event after a battle, such as finding a chest or encountering a shop.
     * @param hero The hero character.
     */
    private void triggerRandomEvent(Character hero) {
        Random random = new Random();
        double chance = random.nextDouble();
        if (chance < 0.15) {
            triggerChestEvent(hero);
        } else if (chance < 0.40) {
            triggerShopEvent();
        } else {
            System.out.println("THE BATTLE IS OVER.");
        }
    }

    /**
     * Triggers an event where a chest is found, containing an item and possibly some gold.
     * @param hero The hero character.
     */
    public static void triggerChestEvent(Character hero) {
        System.out.println("YOU FIND A CHEST!");
        Inventory inventory = hero.getInventory();
        Random random = new Random();
        Item item = ItemFactory.createRandomItem(hero);
        System.out.println(hero.getName() + " finds " + item.getName() + " in the chest!");
        inventory.addItem(item);
        if (random.nextBoolean()) {
            int goldAmount = random.nextInt(101) + 50;
            inventory.addGold(goldAmount);
            System.out.println("Added " + goldAmount + " gold to inventory from a found chest.");
        }
    }

    /**
     * Triggers an event where a shop is encountered, allowing the hero to purchase items.
     */
    private void triggerShopEvent() {
        System.out.println("YOU FIND A SHOP!");
        openShop(hero);
    }

    /**
     * Opens a shop interface where the hero can buy items.
     * @param hero The hero character.
     */
    private void openShop(Character hero) {
        Shop shop = new Shop(hero);
        shop.displayItems();
        System.out.println("CURRENT GOLD: " + hero.getInventory().getGold());
        shop.attemptToBuyRandomItem(hero);
    }
}

