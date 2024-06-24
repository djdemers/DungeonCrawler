package characters;

/**
 * Enum representing different character classes in the game.
 * Each character class can have unique capabilities and play styles.
 */
public enum CharacterClass {
    WARRIOR,  // Class focused on strength and melee combat.
    MAGE,     // Class focused on magic and ranged attacks.
    ROGUE,    // Class skilled in stealth and quick attacks.
    ARCHER;   // Class specialized in long-range attacks.

    /**
     * Returns a randomly selected character class.
     * This method is useful for generating characters with random classes.
     *
     * @return a randomly chosen character class from the available types.
     */
    public static CharacterClass getRandomClass() {
        return values()[(int) (Math.random() * values().length)];
    }
}
