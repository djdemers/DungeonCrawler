package enemies.effects;

import characters.Character;

import java.util.*;

public class StatusEffectManager {
    private Map<Character, List<Effect>> effects = new HashMap<>();

    public void applyEffect(Character character, Effect effect) {
        effects.computeIfAbsent(character, k -> new ArrayList<>()).add(effect);
        effect.applyEffect(character);
    }

    public void updateEffects(Character character) {
        List<Effect> characterEffects = effects.get(character);
        if (characterEffects != null) {
            Iterator<Effect> it = characterEffects.iterator();
            while (it.hasNext()) {
                Effect effect = it.next();
                effect.decreaseDuration();
                if (effect.isExpired()) {
                    effect.removeEffect(character);
                    it.remove();
                }
            }
        }
    }


}

