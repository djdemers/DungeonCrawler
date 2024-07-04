package characters.skills;

import characters.Character;
import enemies.Enemy;

import java.util.*;

/**
 * Manages skills and their effects on characters within the game, handling
 * activation, cooldowns, and temporary effects.
 */
public class SkillManager {

    private int currentTurn = 0;
    private Map<Character, List<TemporaryEffect>> activeEffects = new HashMap<>();
    private Map<Character, Map<Skill, Integer>> skillCooldowns = new HashMap<>();

    /**
     * Attempts to activate a skill on a target enemy if the skill is available and not on cooldown.
     *
     * @param skill The skill to activate.
     * @param caster The character casting the skill.
     * @param target The enemy targeted by the skill.
     * @return true if the skill is successfully activated, false otherwise.
     */
    public boolean activateSkill(Skill skill, Character caster, Enemy target) {
        if (skill.isAvailable(caster) && isSkillOffCooldown(skill, caster)) {
            skill.consumeMana(caster);  // Deduct mana cost
            skill.activateAttack(caster, target);
            recordSkillUsage(skill, caster);
            if (skill.getDuration() > 0) {
                addTemporaryEffect(caster, skill);
            }
            return true;
        } else {
            System.out.println("Skill not available or on cooldown.");
            return false;
        }
    }

    /**
     * Adds a temporary effect to the caster from an activated skill.
     *
     * @param caster The character that cast the skill.
     * @param skill The skill that was activated.
     */
    private void addTemporaryEffect(Character caster, Skill skill) {
        List<TemporaryEffect> effects = activeEffects.computeIfAbsent(caster, k -> new ArrayList<>());
        effects.add(new TemporaryEffect(skill, skill.getDuration(), () -> skill.deactivate(caster)));
    }

    /**
     * Checks if a skill is off cooldown for a given character.
     *
     * @param skill The skill to check.
     * @param caster The character to check for.
     * @return true if the skill is off cooldown, false otherwise.
     */
    public boolean isSkillOffCooldown(Skill skill, Character caster) {
        return !skillCooldowns.containsKey(caster)
                ||
                !skillCooldowns.get(caster).containsKey(skill)
                ||
                currentTurn - skillCooldowns.get(caster).get(skill) >= skill.getCooldown();
    }

    /**
     * Records the usage of a skill to start its cooldown.
     *
     * @param skill The skill used.
     * @param caster The character who used the skill.
     */
    public void recordSkillUsage(Skill skill, Character caster) {
        if (!skillCooldowns.containsKey(caster)) {
            skillCooldowns.put(caster, new HashMap<>());
        }
        skillCooldowns.get(caster).put(skill, currentTurn);
    }

    /**
     * Updates and manages the effects of all active skills on all characters.
     * This includes decreasing the duration of effects and removing them if expired.
     */
    public void updateEffects() {
        activeEffects.forEach((character, effects) -> {
            Iterator<TemporaryEffect> it = effects.iterator();
            while (it.hasNext()) {
                TemporaryEffect effect = it.next();
                effect.decreaseDuration();
                if (effect.isExpired()) {
                    effect.endEffect();
                    it.remove();
                }
            }
        });
    }

    /**
     * Advances to the next turn, updating all skill effects accordingly.
     */
    public void nextTurn() {
        currentTurn++;
        updateEffects();
    }

    /**
     * Nested class to handle the duration and end effects of temporary skill effects on characters.
     */
    private class TemporaryEffect {
        private Skill skill;
        private int remainingDuration;
        private Runnable endEffectAction;

        /**
         * Constructs a TemporaryEffect for managing a skill's effect over time.
         *
         * @param skill The skill causing the effect.
         * @param duration The duration of the effect in turns.
         * @param endEffectAction The action to perform when the effect expires.
         */
        public TemporaryEffect(Skill skill, int duration, Runnable endEffectAction) {
            this.skill = skill;
            this.remainingDuration = duration;
            this.endEffectAction = endEffectAction;
        }

        /**
         * Decreases the duration of the effect each turn.
         */
        void decreaseDuration() {
            remainingDuration--;
        }

        /**
         * Checks if the effect has expired.
         *
         * @return true if the effect has expired, false otherwise.
         */
        boolean isExpired() {
            return remainingDuration <= 0;
        }

        /**
         * Ends the effect and performs any necessary cleanup actions.
         */
        void endEffect() {
            endEffectAction.run();
        }
    }
}
