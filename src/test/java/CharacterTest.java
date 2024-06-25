import static org.junit.Assert.*;

import characters.Character;
import characters.Race;
import characters.Warrior;
import characters.decorators.Armor;
import characters.decorators.Sword;
import org.junit.Before;
import org.junit.Test;

public class CharacterTest {
    private Character hero;
    private Sword sword;
    private Armor armor;

    @Before
    public void setUp() {
        hero = new Warrior("Big boy", Race.HUMAN);
        //Warrior baseAttack: 10, baseDefense: 5
        //Human baseAttack: 2, baseDefense: 2
        sword = new Sword(hero, 5);  // add 5 attack power
        armor = new Armor(hero, 3);  // add 3 defense
    }

    @Test
    public void testEquipDecorator() {
        hero.equipDecorator(sword);
        assertEquals("Attack power should increase by 5.", 17, hero.getAttackPower());
    }

    @Test
    public void testUnequipDecorator() {
        hero.equipDecorator(sword);
        hero.unequipDecorator(Sword.class);
        assertEquals("Attack power should revert to 10 after unequipping.", 12, hero.getAttackPower());
    }

    @Test
    public void testAttemptToEquipDecoratorWithReplacement() {
        hero.equipDecorator(sword); //expect 17
        Sword betterSword = new Sword(hero, 10); // expect 22
        hero.attemptToEquipDecorator(betterSword);
        assertEquals("Attack power should be increased by 10 from the better sword.", 22, hero.getAttackPower());
    }

    @Test
    public void testAttemptToEquipDecoratorWithoutReplacement() {
        hero.equipDecorator(sword); //expect 17
        Sword weakerSword = new Sword(hero, 3); // expect 15
        hero.attemptToEquipDecorator(weakerSword);
        assertEquals("Attack power should remain with the original sword's boost.", 15, hero.getAttackPower());
    }
}

