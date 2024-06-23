package enemies;

public enum EnemyType {
        GOBLIN, RAT, SPIDER, // Small enemies
        TROLL,               // Medium enemies
        DRAGON;              // Boss enemies

        public static EnemyType getRandomSmallEnemy() {
                EnemyType[] small = {GOBLIN, RAT, SPIDER};
                return small[(int) (Math.random() * small.length)];
        }

        public static EnemyType getRandomMediumEnemy() {

                return TROLL;
        }

        public static EnemyType getRandomBossEnemy() {

                return DRAGON;
        }
}

