package characters.skills;

import characters.Character;
import java.util.*;

public class SkillManager {

    private int currentTurn = 0;
    private Map<Character, List<TemporaryEffect>> activeEffects = new HashMap<>();
    private Map<Character, Map<Skill, Integer>> skillCooldowns = new HashMap<>();

    public void activateSkill(Skill skill, Character caster, Character target) {
        if (skill.isAvailable(caster) && isSkillOffCooldown(skill, caster)) {
            skill.activate(caster, target);
            recordSkillUsage(skill, caster);
            if (skill.hasDuration()) {
                addTemporaryEffect(caster, skill);
            }
        } else {
            System.out.println("Skill not available or on cooldown.");
        }
    }

    private void addTemporaryEffect(Character caster, Skill skill) {
        List<TemporaryEffect> effects = activeEffects.computeIfAbsent(caster, k -> new ArrayList<>());
        effects.add(new TemporaryEffect(skill, skill.getDuration(), () -> skill.deactivate(caster)));
    }
    public void attemptToUseSkill(Character caster, Skill skill, Character target) {
        if (skill.isAvailable(caster) && isSkillOffCooldown(skill, caster)) {
            skill.activate(caster, target);
            recordSkillUsage(skill, caster);  // Manages cooldown start
        }
    }
    public boolean isSkillOffCooldown(Skill skill, Character caster) {
        return !skillCooldowns.containsKey(caster) ||
                !skillCooldowns.get(caster).containsKey(skill) ||
                currentTurn - skillCooldowns.get(caster).get(skill) >= skill.getCooldown();
    }

    public void recordSkillUsage(Skill skill, Character caster) {
        if (!skillCooldowns.containsKey(caster)) {
            skillCooldowns.put(caster, new HashMap<>());
        }
        skillCooldowns.get(caster).put(skill, currentTurn);
    }


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
    public void setCurrentTurn(int turn) {
        this.currentTurn = turn;
    }

    public void nextTurn() {
        currentTurn++;
        updateEffects();
    }

    private class TemporaryEffect {
        private Skill skill;
        private int remainingDuration;
        private Runnable endEffectAction;

        public TemporaryEffect(Skill skill, int duration, Runnable endEffectAction) {
            this.skill = skill;
            this.remainingDuration = duration;
            this.endEffectAction = endEffectAction;
        }

        void decreaseDuration() {
            remainingDuration--;
        }

        boolean isExpired() {
            return remainingDuration <= 0;
        }

        void endEffect() {
            endEffectAction.run();
        }
    }
}
