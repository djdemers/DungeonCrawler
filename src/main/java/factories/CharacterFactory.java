package factories;

import characters.Archer;
import characters.Character;
import characters.CharacterClass;
import characters.Mage;
import characters.Race;
import characters.Rogue;
import characters.Warrior;

/**
 * Factory class for creating character instances.
 * This class provides a static method to create characters with randomly assigned classes and races.
 */
public class CharacterFactory {

    /**
     * Creates a character with a randomly selected class and race.
     *
     * @param name The name of the character to be created.
     * @return A new instance of a character with specified name, random class, and random race.
     * @throws IllegalArgumentException If the randomly selected character class is unknown.
     */
    public static Character createRandomCharacter(String name) {
        Race race = Race.getRandomRace();
        CharacterClass charClass = CharacterClass.getRandomClass();

        switch (charClass) {
            case WARRIOR:
                return new Warrior(name, race);
            case MAGE:
                return new Mage(name, race);
            case ROGUE:
                return new Rogue(name, race);
            case ARCHER:
                return new Archer(name, race);
            default:
                throw new IllegalArgumentException("Unknown class: " + charClass);
        }
    }
}

