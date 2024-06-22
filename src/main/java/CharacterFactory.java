public class CharacterFactory {
    public static Character createCharacter(String type, String name, Race race) {
        switch (type.toLowerCase()) {
            case "warrior":
                return new CharWarrior(name, race);
            case "mage":
                return new CharMage(name, race);
            case "archer":
                return new CharArcher(name, race);
            case "rogue":
                return new CharRogue(name, race);
            default:
                throw new IllegalArgumentException("Unknown character type: " + type);
        }
    }
}
