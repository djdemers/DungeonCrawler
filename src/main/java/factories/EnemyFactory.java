package factories;

import enemies.*;

/**
 * Factory class for creating enemies. This class abstracts the instantiation
 * of different types of enemies based on the specified enemy type.
 */
public class EnemyFactory {

    /**
     * Creates an enemy of the specified type.
     *
     * @param type The type of enemy to create.
     * @return The newly created enemy object.
     * @throws IllegalArgumentException if the provided type is not recognized.
     */
    public static Enemy createEnemy(EnemyType type) {
        switch (type) {
            case GOBLIN:
                return new Goblin();
            case RAT:
                return new Rat();
            case SPIDER:
                return new Spider();
            case TROLL:
                return new Troll();
            case DRAGON:
                return new Dragon();
            default:
                throw new IllegalArgumentException("Unknown enemy type: " + type);
        }
    }

    /**
     * Creates a random small enemy.
     *
     * @return A new instance of a random small enemy.
     */
    public static Enemy createRandomSmallEnemy() {
        return createEnemy(EnemyType.getRandomSmallEnemy());
    }

    /**
     * Creates a random medium enemy.
     *
     * @return A new instance of a random medium enemy.
     */
    public static Enemy createRandomMediumEnemy() {
        return createEnemy(EnemyType.getRandomMediumEnemy());
    }

    /**
     * Creates a random boss enemy.
     *
     * @return A new instance of a random boss enemy.
     */
    public static Enemy createRandomBoss() {
        return createEnemy(EnemyType.getRandomBossEnemy());
    }
}

