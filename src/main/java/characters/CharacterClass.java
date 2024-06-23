package characters;

public enum CharacterClass {
    WARRIOR,
    MAGE,
    ROGUE,
    ARCHER;

    public static CharacterClass getRandomClass() {
        return values()[(int) (Math.random() * values().length)];
    }
}