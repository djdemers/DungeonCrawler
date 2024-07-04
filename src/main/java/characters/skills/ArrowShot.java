package characters.skills;

import characters.Archer;
import characters.Character;
import enemies.Enemy;

public class ArrowShot extends Skill {
    private int damage;

    public ArrowShot() {
        super("Arrow Shot", "Shoots a precise arrow at the target.", 1, 3, 1);
        this.damage = 10;
    }

    @Override
    public void activateAttack(Character caster, Enemy target) {
        if (!(caster instanceof Archer)) {
            throw new IllegalArgumentException("Arrow Shot can only be activated by Archers.");
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

