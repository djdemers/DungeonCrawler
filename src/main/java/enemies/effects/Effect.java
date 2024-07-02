package enemies.effects;

import characters.Character;
public class Effect {
    private int duration;
    private Runnable effectApply;
    private Runnable effectRemove;

    public Effect(int duration, Runnable effectApply, Runnable effectRemove) {
        this.duration = duration;
        this.effectApply = effectApply;
        this.effectRemove = effectRemove;
    }

    /**
     * Decreases the duration of the effect by one unit.
     * Typically called once per turn or game cycle.
     */
    public void decreaseDuration() {
        if (duration > 0) {
            duration--;
        }
    }

    /**
     * Applies the effect's action to the character.
     * This should be called when the effect is first added.
     */
    public void applyEffect(Character character) {
        effectApply.run();
    }

    /**
     * Removes the effect's action from the character.
     * This should be called when the effect expires.
     */
    public void removeEffect(Character character) {
        effectRemove.run();
    }

    /**
     * Checks if the effect has expired.
     * @return true if the duration has reached 0 or less, false otherwise.
     */
    public boolean isExpired() {
        return duration <= 0;
    }
}

