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
        hero = new Warrior("Warrior", Race.HUMAN);
        nonWarrior = new Mage("NonWarrior",Race.HUMAN);
        rage = new Rage();
        skillManager = new SkillManager();
        skillManager.setCurrentTurn(0); // Initialize game turn to 0
    }

    @Test
    public void rageActivatesOnlyForWarriors() {
        assertThrows(ClassCastException.class, () -> rage.activate(nonWarrior, nonWarrior),
                "Rage should only be activatable by Warrior class characters.");
    }

    @Test
    public void rageIncreasesAttackPowerWhenActivated() {
        int originalAttackPower = hero.getAttackPower();
        skillManager.activateSkill(rage, hero, null); // Activating the skill
        assertEquals(originalAttackPower + 5, hero.getAttackPower(),
                "Rage should increase the hero's attack power by 5.");
    }

    @Test
    public void rageEffectEndsAfterDuration() {
        skillManager.activateSkill(rage, hero, null);
        skillManager.nextTurn(); // Advance game turn to simulate time passing
        skillManager.nextTurn(); // Advance another turn to complete duration
        assertEquals(hero.getAttackPower(), 100, // Assuming the original attack power was 100
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

