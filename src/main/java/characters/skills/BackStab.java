package characters.skills;

import characters.Character;
import characters.Rogue;
import enemies.Enemy;

public class BackStab extends Skill {
    private int damage;

    public BackStab() {
        super("Backstab", "A surprise attack that deals extra damage.", 1, 4, 1);
        this.damage = 15;
    }

    @Override
    public void activateAttack(Character caster, Enemy target) {
        if (!(caster instanceof Rogue)) {
            throw new IllegalArgumentException("Backstab can only be activated by Rogues.");
        }
        if (isAvailable(caster)) {
            consumeMana(caster);
            applyDamage(target);
        } else {
            throw new IllegalStateException("Skill not available or not enough resources.");
        }
    }

    private void applyDamage(Enemy target) {
        target.reduceEnemyHealth(damage);
        System.out.println(getName() + " deals " + damage + " damage to " + target.getName() + ".");
    }

    @Override
    public void deactivate(Character caster) {
        // No deactivation effect needed
    }
}
