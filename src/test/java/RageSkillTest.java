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
    private Character hero;
    private Character nonWarrior;
    private Skill rage;
    private SkillManager skillManager;

    @BeforeEach
    public void setUp() {
        // Initialize with specific classes
        hero = new Warrior("Warrior", Race.HUMAN);
        nonWarrior = new Mage("Mage", Race.HUMAN); // Mage class for clear differentiation
        hero.setMana(20);
        hero.setAttackPower(12);
        rage = new Rage();
        skillManager = new SkillManager();
        skillManager.setCurrentTurn(0);
        skillManager.recordSkillUsage(rage, hero);
        skillManager.setCurrentTurn(rage.getCooldown());
    }

    @Test
    public void rageActivatesOnlyForWarriors() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> rage.activate(nonWarrior, null),
                "Expected IllegalArgumentException for non-warriors trying to activate Rage.");
        assertTrue(exception.getMessage().contains("can only be activated by Warriors"));
    }

    @Test
    public void rageIncreasesAttackPowerWhenActivated() {
        int originalAttackPower = hero.getAttackPower();
        skillManager.activateSkill(rage, hero, hero); // Activating the skill
        assertEquals(originalAttackPower + 5, hero.getAttackPower(),
                "Rage should increase the hero's attack power by 5.");
    }

    @Test
    public void rageEffectEndsAfterDuration() {
        skillManager.activateSkill(rage, hero, null);
        skillManager.nextTurn(); // Advance game turn to simulate time passing
        skillManager.nextTurn(); // Advance another turn to complete duration
        assertEquals(12, hero.getAttackPower(),
                "Rage effect should end after 2 turns, reverting attack power to its original state.");
    }

    @Test
    public void rageRespectsCooldown() {
        skillManager.activateSkill(rage, hero, null);
        assertFalse(skillManager.isSkillOffCooldown(rage, hero),
                "Rage should not be off cooldown immediately after use.");
        skillManager.nextTurn(); // Simulate cooldown expiration
        assertTrue(skillManager.isSkillOffCooldown(rage, hero),
                "Rage should be off cooldown after 1 turn.");
    }
}


