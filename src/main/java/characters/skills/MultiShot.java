package characters.skills;

import characters.Archer;
import characters.Character;
import enemies.Enemy;

public class MultiShot extends Skill {
    private int damage;

    public MultiShot() {
        super("Multi Shot", "Shoots multiple arrows at once.", 1, 6, 2);
        this.damage = 8;
    }

    @Override
    public void activateAttack(Character caster, Enemy target) {
        if (!(caster instanceof Archer)) {
            throw new IllegalArgumentException("Multi Shot can only be activated by Archers.");
        }
        if (isAvailable(caster)) {
            applyDamage(target);
            consumeMana(caster);
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

