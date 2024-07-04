package interfaces;

import enemies.Enemy;

public interface EnemyScalingStrategy {
    void scaleEnemyAttributes(Enemy enemy, int currentFloor);
}
