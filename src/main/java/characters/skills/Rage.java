package characters.skills;

import characters.Character;
import characters.Warrior;

public class Rage extends Skill {
    private int attackBoost;

    public Rage() {
        super("Rage", "Temporarily boosts attack power.", 1, 5, 2);
        this.attackBoost = 5;
    }

    @Override
    public void activate(Character caster, Character target) {
        if (!(caster instanceof Warrior)) {
            throw new IllegalArgumentException("Rage can only be activated by Warriors.");
        }
        if (isAvailable(caster)) {
            applyBoost(caster);
        } else {
            throw new IllegalStateException("Skill not available or not enough resources.");
        }
    }


    private void applyBoost(Character caster) {
        caster.setAttackPower(caster.getAttackPower() + attackBoost);
        System.out.println(caster.getName() + " uses " + getName() + ", increasing attack power by " + attackBoost + ".");
    }

    @Override
    public void deactivate(Character caster) {
        caster.setAttackPower(caster.getAttackPower() - attackBoost);
        System.out.println(getName() + " effect ends, decreasing " + caster.getName() + "'s attack power by " + attackBoost + ".");
    }
}
