public class CharacterFactory {
    public static Character createCharacter(String type, String name, Race race) {
        switch (type.toLowerCase()) {
            case "warrior":
                return new CharWarrior(name, race);
            case "mage":
                return new Mage(name, race);
            case "archer":
                return new Archer(name, race);
            case "rogue":
                return new Rogue(name, race);
            default:
                throw new IllegalArgumentException("Unknown character type: " + type);
        }
    }
}
