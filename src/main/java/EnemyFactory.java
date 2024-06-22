public class EnemyFactory {
    public static Enemy createEnemy(String type) {
        switch (type.toLowerCase()) {
            case "goblin":
                return new Goblin();
            case "troll":
                return new Troll();
            case "dragon":
                return new Dragon();
            default:
                throw new IllegalArgumentException("Unknown enemy type: " + type);
        }
    }
}
