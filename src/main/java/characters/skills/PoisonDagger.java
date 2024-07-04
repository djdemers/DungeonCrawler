package characters.skills;

import characters.Character;
import characters.Rogue;
import enemies.Enemy;

public class PoisonDagger extends Skill {
    private int damage;

    public PoisonDagger() {
        super("Poison Dagger", "A dagger coated with poison that deals damage over time.", 1, 5, 2);
        this.damage = 10;
    }

    @Override
    public void activateAttack(Character caster, Enemy target) {
        if (!(caster instanceof Rogue)) {
            throw new IllegalArgumentException("Poison Dagger can only be activated by Rogues.");
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

