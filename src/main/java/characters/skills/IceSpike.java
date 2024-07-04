package characters.skills;

import characters.Character;
import characters.Mage;
import enemies.Enemy;

public class IceSpike extends Skill {
    private int damage;

    public IceSpike() {
        super("Ice Spike", "Shoots a spike of ice that deals damage and slows the target.", 1, 4, 3);
        this.damage = 15;
    }

    @Override
    public void activateAttack(Character caster, Enemy target) {
        if (!(caster instanceof Mage)) {
            throw new IllegalArgumentException("Ice Spike can only be activated by Mages.");
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
