package enemies;

/**
 * Enum representing different types of enemies in the game.
 * This enum categorizes enemies into small, medium, and boss types,
 * allowing for easy retrieval of a random enemy type based on the desired difficulty level.
 */
public enum EnemyType {
        GOBLIN, RAT, SPIDER,
        TROLL, BEAR, WRAITH,
        DRAGON, GIANT, SWORDMASTER;

        /**
         * Returns a randomly selected small enemy type.
         * Small enemies are generally weaker and less complex in terms of game mechanics.
         *
         * @return A randomly selected small enemy type.
         */
        public static EnemyType getRandomSmallEnemy() {
                EnemyType[] small = {GOBLIN, RAT, SPIDER};
                return small[(int) (Math.random() * small.length)];
        }

        /**
         * Returns a randomly selected medium enemy type.
         * Medium enemies offer a moderate challenge, suitable for testing player progress mid-game.
         *
         * @return A randomly selected medium enemy type.
         */
        public static EnemyType getRandomMediumEnemy() {
                EnemyType[] medium = {TROLL, WRAITH, BEAR};
                return medium[(int) (Math.random() * medium.length)];
        }

        /**
         * Returns a randomly selected boss enemy type.
         * Boss enemies are the most challenging and are typically encountered at climactic points in the game.
         *
         * @return A randomly selected boss enemy type.
         */
        public static EnemyType getRandomBossEnemy() {
                EnemyType[] boss = {DRAGON, GIANT, SWORDMASTER};
                return boss[(int) (Math.random() * boss.length)];
        }
}

