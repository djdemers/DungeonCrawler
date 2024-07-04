package factories;

import enemies.*;
import interfaces.EnemyScalingStrategy;

/**
 * Factory class for creating enemies. This class abstracts the instantiation
 * of different types of enemies based on the specified enemy type and scales
 * them according to a given strategy.
 */
public class EnemyFactory {

    private EnemyScalingStrategy scalingStrategy;

    public EnemyFactory(EnemyScalingStrategy scalingStrategy) {
        this.scalingStrategy = scalingStrategy;
    }

    /**
     * Creates an enemy of the specified type and applies scaling based on the floor number.
     *
     * @param type The type of enemy to create.
     * @param currentFloor The current floor number to base the scaling on.
     * @return The newly created and scaled enemy object.
     * @throws IllegalArgumentException if the provided type is not recognized.
     */
    public Enemy createEnemy(EnemyType type, int currentFloor) {
        Enemy enemy;
        switch (type) {
            case GOBLIN:
                enemy = new Goblin();
                break;
            case RAT:
                enemy = new Rat();
                break;
            case SPIDER:
                enemy = new Spider();
                break;
            case TROLL:
                enemy = new Troll();
                break;
            case BEAR:
                enemy = new Bear();
                break;
            case WRAITH:
                enemy = new Wraith();
                break;
            case GIANT:
                enemy = new Giant();
                break;
            case DRAGON:
                enemy = new Dragon();
                break;
            case SWORDMASTER:
                enemy = new SwordMaster();
                break;
            default:
                throw new IllegalArgumentException("Unknown enemy type: " + type);
        }
        scalingStrategy.scaleEnemyAttributes(enemy, currentFloor);
        return enemy;
    }

    /**
     * Creates a random small enemy and applies scaling.
     *
     * @param currentFloor The current floor number to base the scaling on.
     * @return A new instance of a random small enemy.
     */
    public Enemy createRandomSmallEnemy(int currentFloor) {
        return createEnemy(EnemyType.getRandomSmallEnemy(), currentFloor);
    }

    /**
     * Creates a random medium enemy and applies scaling.
     *
     * @param currentFloor The current floor number to base the scaling on.
     * @return A new instance of a random medium enemy.
     */
    public Enemy createRandomMediumEnemy(int currentFloor) {
        return createEnemy(EnemyType.getRandomMediumEnemy(), currentFloor);
    }

    /**
     * Creates a random boss enemy and applies scaling.
     *
     * @param currentFloor The current floor number to base the scaling on.
     * @return A new instance of a random boss enemy.
     */
    public Enemy createRandomBoss(int currentFloor) {
        return createEnemy(EnemyType.getRandomBossEnemy(), currentFloor);
    }
}
