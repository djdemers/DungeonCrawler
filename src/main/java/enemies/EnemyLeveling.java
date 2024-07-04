package enemies;

import interfaces.EnemyScalingStrategy;

public class EnemyLeveling implements EnemyScalingStrategy {
    private static final int HEALTH_INCREMENT = 5;  // Adjusted for a more noticeable scaling effect
    private static final int ATTACK_INCREMENT = 2;  // Adjusted for balance
    private static final int DEFENSE_INCREMENT = 1;
    private static final int SPEED_INCREMENT = 1;

    @Override
    public void scaleEnemyAttributes(Enemy enemy, int currentFloor) {
        // Use enemy's initial stats as the base, and scale them according to the current floor
        int newHealth = enemy.getHealth() + HEALTH_INCREMENT * currentFloor;
        int newAttackPower = enemy.getAttackPower() + ATTACK_INCREMENT * currentFloor;
        int newDefense = enemy.getDefense() + DEFENSE_INCREMENT * currentFloor;
        int newSpeed = enemy.getSpeed() + SPEED_INCREMENT * currentFloor;

        // Setting the scaled attributes back to the enemy
        enemy.setHealth(newHealth);
        enemy.setAttackPower(newAttackPower);
        enemy.setDefense(newDefense);
        enemy.setSpeed(newSpeed);


        System.out.println("Scaled " + enemy.getName() + ": Health: " + newHealth + ", Attack: " + newAttackPower
                + ", Speed: " + newSpeed +  ", Defense: " + newDefense);
    }
}
