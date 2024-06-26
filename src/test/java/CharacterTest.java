import static org.junit.jupiter.api.Assertions.assertEquals;

import characters.Character;
import characters.Race;
import characters.Warrior;
import characters.decorators.Armor;
import characters.decorators.Sword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    private Character hero;
    private Sword sword;
    private Armor armor;

    @BeforeEach
    public void setUp() {
        hero = new Warrior("Big boy", Race.HUMAN);
        // Warrior baseAttack: 10, baseDefense: 5
        // Human baseAttack: 2, baseDefense: 2
        sword = new Sword(hero, 5);  // add 5 attack power
        armor = new Armor(hero, 3);  // add 3 defense
    }

    @Test
    public void testEquipDecorator() {
        hero.equipDecorator(sword);
        assertEquals(17, hero.getAttackPower(), "Attack power should increase by 5.");
    }

    @Test
    public void testUnequipDecorator() {
        hero.equipDecorator(sword);
        hero.unequipDecorator(Sword.class);
        assertEquals(12, hero.getAttackPower(), "Attack power should revert to 12 after unequipping.");
    }

    @Test
    public void testAttemptToEquipDecoratorWithReplacement() {
        hero.equipDecorator(sword); //expect 17
        Sword betterSword = new Sword(hero, 10); // expect 22
        hero.attemptToEquipDecorator(betterSword);
        assertEquals(22, hero.getAttackPower(), "Attack power should be increased by 10 from the better sword.");
    }

    @Test
    public void testAttemptToEquipDecoratorWithoutReplacement() {
        hero.equipDecorator(sword); //expect 17
        Sword weakerSword = new Sword(hero, 3); // expect 15
        hero.attemptToEquipDecorator(weakerSword);
        assertEquals(15, hero.getAttackPower(), "Attack power should remain with the original sword's boost.");
    }
}
