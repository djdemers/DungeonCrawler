import static org.junit.jupiter.api.Assertions.*;

import characters.Mage;
import characters.Race;
import characters.Warrior;
import characters.skills.Rage;
import characters.skills.Skill;
import characters.skills.SkillManager;
import characters.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RageSkillTest {
    private Character warrior;
    private Character mage;
    private Skill rage;
    private SkillManager skillManager;

    @BeforeEach
    public void setUp() {
        warrior = new Warrior("Warrior", Race.HUMAN);
        mage = new Mage("Mage", Race.HUMAN); // Mage class for clear differentiation
        warrior.setMana(20);
        warrior.setAttackPower(12);
        rage = new Rage();
        skillManager = new SkillManager();

        // Simulate cooldown passing by advancing the turn count
        for (int i = 0; i < rage.getCooldown(); i++) {
            skillManager.nextTurn();
        }
    }

    @Test
    public void rageActivatesOnlyForWarriors() {
        // Expecting an exception when Rage is activated by a non-warrior
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> rage.activateAttack(mage, null),
                "Rage should only be activatable by Warriors.");

        String expectedMessage = "Rage can only be activated by Warriors";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    public void rageIncreasesAttackPowerWhenActivated() {
        int originalAttackPower = warrior.getAttackPower();
        skillManager.activateSkill(rage, warrior, null); // Activating the skill
        assertEquals(originalAttackPower + 5, warrior.getAttackPower(),
                "Rage should increase the warrior's attack power by 5.");
    }

    @Test
    public void rageEffectEndsAfterDuration() {
        skillManager.activateSkill(rage, warrior, null);
        skillManager.nextTurn(); // Advance game turn to simulate time passing
        skillManager.nextTurn(); // Advance another turn to complete duration
        assertEquals(12, warrior.getAttackPower(),
                "Rage effect should end after 2 turns, reverting attack power to its original state.");
    }

    @Test
    public void rageRespectsCooldown() {
        skillManager.activateSkill(rage, warrior, null);
        assertFalse(skillManager.isSkillOffCooldown(rage, warrior),
                "Rage should not be off cooldown immediately after use.");
        skillManager.nextTurn(); // Advance one turn, still within cooldown period
        assertTrue(skillManager.isSkillOffCooldown(rage, warrior),
                "Rage should be off cooldown after its cooldown period expires.");
    }
}


