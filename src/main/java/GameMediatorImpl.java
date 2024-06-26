import characters.Character;
import enemies.Enemy;
import factories.EnemyFactory;

/**
 * Implementation of the GameMediator interface to manage combat and level progression in the game.
 */
public class GameMediatorImpl implements GameMediator {
    private Character hero;
    private int currentLevel = 1;

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
        while (this.hero.isAlive() && enemy.isAlive()) {
            this.hero.attackEnemy(enemy);
            if (enemy.isAlive()) {
                enemy.attackHero(this.hero);
            }
        }
        if (!this.hero.isAlive()) {
            gameOver();
        } else {
            System.out.println(this.hero.getName() + " has defeated " + enemy.getName() + "!");
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
}
