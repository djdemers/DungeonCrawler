package factories;

import characters.*;
import characters.Character;

public class CharacterFactory {
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

