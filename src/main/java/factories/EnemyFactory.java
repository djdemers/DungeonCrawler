package factories;

import enemies.*;
import enemies.Enemy;

public class EnemyFactory {

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

    public static Enemy createRandomSmallEnemy() {
        return createEnemy(EnemyType.getRandomSmallEnemy());
    }

    public static Enemy createRandomMediumEnemy() {
        return createEnemy(EnemyType.getRandomMediumEnemy());
    }

    public static Enemy createRandomBoss() {
        return createEnemy(EnemyType.getRandomBossEnemy());
    }
}


