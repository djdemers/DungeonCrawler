package characters.skills;

import characters.Character;
import characters.Warrior;
import enemies.Enemy;

public class ShieldBash extends Skill {
    private int damage;

    public ShieldBash() {
        super("Shield Bash", "Bashes the enemy with a shield, causing damage and stunning.", 1, 5, 3);
        this.damage = 10;
    }

    @Override
    public void activateAttack(Character caster, Enemy target) {
        if (!(caster instanceof Warrior)) {
            throw new IllegalArgumentException("Shield Bash can only be activated by Warriors.");
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
